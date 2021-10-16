package com.bank.controller;

import com.bank.dto.OperationDto;
import com.bank.mapper.OperationMapper;
import com.bank.service.OperationDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/operation")
@RequiredArgsConstructor
public class OperationController {

    private final OperationDbService operationDbService;
    private final OperationMapper operationMapper;

    @GetMapping("getOperations")
    public List<OperationDto> getAllOperations() {
        return operationMapper.mapToOperationDtoList(
                operationDbService.getAllOperations()
        );
    }

    @GetMapping("getOperationById")
    public OperationDto getOperationById (@RequestParam Long operationId) {
        return operationMapper.mapToOperationDto(
                operationDbService.getOperationById(operationId)
        );
    }

    @PostMapping("createOperation")
    public void createOperation(@RequestBody OperationDto operationDto) {
        operationDbService.createOperation(
                operationMapper.mapToOperation(operationDto)
        );
    }

    @PostMapping("makeTransfer")
    public void makeTransfer(@RequestBody OperationDto operationDto) {

    }

    @DeleteMapping("deleteOperation")
    public void deleteOperationById(@RequestParam Long operationId) {
        operationDbService.deleteOperationById(operationId);
    }


}
