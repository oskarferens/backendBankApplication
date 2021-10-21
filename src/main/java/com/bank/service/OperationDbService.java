package com.bank.service;

import com.bank.domain.Account;
import com.bank.domain.Operation;
import com.bank.exception.OperationNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationDbService {

    @Autowired
    Account account;
    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;

    public Operation findByOperationId(Long operationId) {
        return operationRepository.findByOperationId(operationId);
    }

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Operation createOperation(final Operation operation) {
        return operationRepository.save(operation);
    }

    public void deleteOperationById (Long operationId) {
        operationRepository.deleteById(operationId);
    }

    public void makeTransfer(Long from, Long to, BigDecimal value) {
        Account actFrom = accountRepository.findAccountByAccountId(from);
        Account actTo = accountRepository.findAccountByAccountId(to);
        actFrom.setBalance(actFrom.getBalance().add(value));
        actTo.setBalance(actTo.getBalance().add(value));
        accountRepository.save(actFrom);
        accountRepository.save(actTo);
    }
}

//A tu przekazujesz takie parametry jakie zdefiniowałeś w dbService w tej metodzie

//Musisz wyszukać account po id klienta od którego robisz przelew.
// Potem zmodyfikować stan tego accounta (pobrać kasę) i zapisać.
// Następnie wyszukac docelowego, zmodyfikować stan konta (dodac kasę) i zapisać.

// Operations service bedzie mialo metode makeTransfer, ktora zrobi przelew w podanej walucie.
// metoda napisana w controllerze ma wywolac z operations service metode makeTransfer i
// przekazac te same parametry.
// makeTransfer w OperationService pobierze kurs waluty przelewu jezeli jest inna niz
// waluta rachunku i przeliczy kwote. I kurs pobierze z ExchangeClient z metody currency.
