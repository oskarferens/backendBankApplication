package com.bank.controller;

import com.bank.domain.Operation;
import com.bank.facade.OperationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/operation")
@RequiredArgsConstructor
public class OperationController {

    private final OperationFacade operationFacade;

    @GetMapping("/getAllOperations")
    public List<Operation> getAllOperations() {
        return operationFacade.getAllOperations();
    }

    @GetMapping("/getOperationById/{operationId}")
    public Operation findByOperationId(@PathVariable Long operationId) {
        return operationFacade.getOperationById(operationId);
    }

    @GetMapping("/getOperationDate")
    public Operation getOperationDate(@RequestParam LocalDate operationDate) {
        return operationFacade.getOperationDate(operationDate);
    }

    @PostMapping(value = "/createOperation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOperation(@RequestBody Operation operation) {
        operationFacade.createOperation(operation);
    }

    @PostMapping(value= "/makeTransfer")
    public void makeTransfer(@RequestParam Long accountFrom, @RequestParam Long accountTo, @RequestParam BigDecimal value) {
        operationFacade.makeTransfer(accountFrom,accountTo,value);
    }

    @DeleteMapping("/deleteOperation")
    public void deleteOperation(@RequestParam Long operationId) {
        operationFacade.deleteOperation(operationId);
    }
}
