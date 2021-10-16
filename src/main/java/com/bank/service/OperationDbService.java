package com.bank.service;

import com.bank.domain.Customer;
import com.bank.domain.Operation;
import com.bank.exception.OperationNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationDbService {

    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;
    private final CustomerRepository customerRepository;

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

    public Operation makeTransfer(//klasa transfer) {

                                  //w klasie transfer component, a tutaj autowired
        accountRepository.findByCustomerId(1L)
        //getAccountByCustomerID
        //getBalance()
        //return customerRepository.findById(ID customera);
        return null;
    }

    public Operation makeInternationalTransfer() {
        return null;
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
