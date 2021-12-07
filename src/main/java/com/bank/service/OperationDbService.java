package com.bank.service;

import com.bank.domain.Account;
import com.bank.domain.Operation;
import com.bank.exception.AccountNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationDbService {

    private final OperationRepository operationRepository;
    private final AccountRepository accountRepository;

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Operation getOperationId(Long operationId) {
        return operationRepository.findById(operationId) .orElseThrow(() ->
                new AccountNotFoundException("Operation with id: " + operationId + "doesn't exsist"));
    }

    public Operation getOperationDate(LocalDate operationDate) {
        return operationRepository.findByOperationDate(operationDate);
    }

    public Operation saveOperation(final Operation operation) {
        return operationRepository.save(operation);
    }

    public void deleteOperationById (Long operationId) {
        operationRepository.deleteById(operationId);
    }

    public void makeTransfer(Long idFrom, Long idTo, BigDecimal value) {
        Account accountFrom = accountRepository.findById(idFrom).orElseThrow(() -> new AccountNotFoundException("Account with id: " + idFrom + " not found"));
        Account accountTo = accountRepository.findById(idTo).orElseThrow(() -> new AccountNotFoundException("Account with id: " + idTo + " not found"));;
        accountFrom.setBalance(accountFrom.getBalance().add(value));
        accountTo.setBalance(accountTo.getBalance().add(value));  //zamienic to na metody ze streama zeby dzialalo
        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);

        Operation newOperation = new Operation(idFrom,idTo,new BigDecimal(100.00),true,false,true,LocalDate.now());
        operationRepository.save(newOperation);                            // tylko ta linijka wywala blad

        //final List<Operation> operations = List.of(operations);
        //operationRepository.save(new Operation(idFrom,idTo,new BigDecimal(100.00),true,false,true,LocalDate.now()));
    }

}