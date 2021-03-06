package com.bank.service;

import com.bank.domain.Account;
import com.bank.domain.Operation;
import com.bank.exception.AccountNotFoundException;
import com.bank.repository.AccountRepository;
import com.bank.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationDbService {

    @Autowired
    OperationRepository operationRepository;
    @Autowired
    AccountRepository accountRepository;

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

    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public void deleteByOperationId (Long operationId) {
        operationRepository.deleteById(operationId);
    }

    public void makeTransfer(Long idFrom, Long idTo, BigDecimal value) {
        Account accountFrom = accountRepository.findById(idFrom).orElseThrow(() -> new AccountNotFoundException("Account with id: " + idFrom + " not found"));
        Account accountTo = accountRepository.findById(idTo).orElseThrow(() -> new AccountNotFoundException("Account with id: " + idTo + " not found"));
        accountFrom.setBalance(accountFrom.getBalance().subtract(value));
        accountTo.setBalance(accountTo.getBalance().add(value));
        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);
        Operation nextOperation = new Operation(idFrom,idTo,value,false,true,true,LocalDate.now());
        operationRepository.save(nextOperation);
    }
}


















