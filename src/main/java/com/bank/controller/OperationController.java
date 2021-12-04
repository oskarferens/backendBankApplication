package com.bank.controller;

import com.bank.domain.Operation;
import com.bank.mapper.OperationMapper;
import com.bank.service.OperationDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/operation")
@RequiredArgsConstructor
public class OperationController {

    private final OperationDbService operationDbService;

    @GetMapping("/getAllOperations")
    public List<Operation> getAllOperations() {
        return operationDbService.getAllOperations();
    }

    @GetMapping("/getOperationById/{operationId}")
    public Operation findByOperationId(@PathVariable Long operationId) {
        return operationDbService.getOperationId(operationId);
    }

    @GetMapping("/getOperationDate")
    public Operation getOperationDate(@RequestParam LocalDate operationDate) {
        return operationDbService.getOperationDate(operationDate);
    }

    @PostMapping(value = "/createOperation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOperation(@RequestBody Operation operation) {
        operationDbService.saveOperation(operation);
    }

    @PostMapping(value= "/makeTransfer")
    public void makeTransfer(@RequestParam Long accountFrom, @RequestParam Long accountTo, @RequestParam BigDecimal value) {
        operationDbService.makeTransfer(accountFrom,accountTo,value);
        //operationDbService.saveOperation(new Operation());
    }

    @DeleteMapping("/deleteOperation")
    public void deleteOperation(@RequestParam Long operationId) {
        operationDbService.deleteOperationById(operationId);
    }
}
