package com.bank.facade;

import com.bank.domain.Customer;
import com.bank.domain.Operation;
import com.bank.service.OperationDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OperationFacade {

    private final OperationDbService operationDbService;

    public List<Operation> getAllOperations() {
        return operationDbService.getAllOperations();
    }

    public Operation getOperationById(Long operationId) {
        return operationDbService.getOperationId(operationId);
    }

    public Operation getOperationDate(LocalDate operationDate) {
        return operationDbService.getOperationDate(operationDate);
    }

    public Operation createOperation (Operation operation) {
        return operationDbService.createOperation(operation);
    }

    public void deleteOperation(Long operationId) {
        operationDbService.deleteOperationById(operationId);
    }

    public void makeTransfer (Long idFrom, Long idTo, BigDecimal value) {
        operationDbService.makeTransfer(idFrom,idTo,value);
    }

}
