package com.bank.service;

import com.bank.domain.Account;
import com.bank.domain.Operation;
import com.bank.exception.OperationNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationDbService {

    @Autowired
    Account account;
    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;

    public Operation getOperationById(Long operationId) {
        return operationRepository.findById(operationId).orElseThrow(() ->
                new OperationNotFoundException("Operation with id: " + operationId + "doesn't exsist"));
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


    public void makeTransfer(Long from, Long to, Integer value) {
        Optional<Account> actFrom = accountRepository.findById(from);
        Account actTo = accountRepository.findById(to);
        actFrom.setBalance(actFrom.getBalance() - value);
        actTo.setBalance(actTo.getBalance() + value);
        accountRepository.save(actFrom.get().setBalance(from).);
        accountRepository.save(actTo);
    }
}
/*

    public void makeTransfer(String from, String to, Integer amount) {
        Account actFrom = accountDto.findAccount(from);
        Account actTo = accountDto.findAccount(to);
        actFrom.saldo -= amount;
        actTo.saldo += amount;
        accountDto.save(actFrom);
        accountDto.save(actTo);
    }
*/

//A tu przekazujesz takie parametry jakie zdefiniowałeś w dbService w tej metodzie

//Musisz wyszukać account po id klienta od którego robisz przelew.
// Potem zmodyfikować stan tego accounta (pobrać kasę) i zapisać.
// Następnie wyszukac docelowego, zmodyfikować stan konta (dodac kasę) i zapisać.

// Operations service bedzie mialo metode makeTransfer, ktora zrobi przelew w podanej walucie.
// metoda napisana w controllerze ma wywolac z operations service metode makeTransfer i
// przekazac te same parametry.
// makeTransfer w OperationService pobierze kurs waluty przelewu jezeli jest inna niz
// waluta rachunku i przeliczy kwote. I kurs pobierze z ExchangeClient z metody currency.
