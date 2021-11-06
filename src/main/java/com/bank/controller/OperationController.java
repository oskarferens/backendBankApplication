package com.bank.controller;

import com.bank.dto.OperationDto;
import com.bank.mapper.OperationMapper;
import com.bank.service.OperationDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/operation")
@RequiredArgsConstructor
public class OperationController {

    private final OperationDbService operationDbService;
    private final OperationMapper operationMapper;

    @GetMapping("/getOperations")
    public List<OperationDto> getAllOperations() {
        return operationMapper.mapToOperationDtoList(
                operationDbService.getAllOperations()
        );
    }

    @GetMapping("/getOperationById")
    public OperationDto findByOperationId (@RequestParam OperationDto operationDto) {
        return operationMapper.mapToOperationDto(operationDbService.findByOperationId(operationDto.getOperationId())
        );
    }

    @GetMapping("/getOperationDate")
    public OperationDto getOperationDate(@RequestParam LocalDate operationDate) {
        return operationMapper.mapToOperationDto(operationDbService.getOperationDate(operationDate)
        );
    }

    @PostMapping("/createOperation")
    public void createOperation(@RequestBody OperationDto operationDto) {
        operationDbService.createOperation(
                operationMapper.mapToOperation(operationDto)
        );
    }

    @PostMapping("/makeTransfer")
    public void makeTransfer(@RequestBody Long from, Long to, BigDecimal value) {
       // operationDbService.makeTransfer(operationMapper.mapToOperation(tu nic nie pasuje));
    }

    @DeleteMapping("/deleteOperation")
    public void deleteOperationById(@RequestParam Long operationId) {
        operationDbService.deleteOperationById(operationId);
    }


}
