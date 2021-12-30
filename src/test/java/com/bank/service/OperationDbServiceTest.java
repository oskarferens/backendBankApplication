package com.bank.service;

/*
import com.bank.domain.Operation;
import com.bank.repository.AccountRepository;
import com.bank.repository.OperationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
class OperationDbServiceTest {

    @Autowired
    private OperationDbService operationDbService;
    @Autowired
    private AccountDbService accountDbService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Test
    public void shouldGetAllOperations() {
        //Given
        Operation operation1 = new Operation(1L,2L,new BigDecimal(100.00),false,true,true, LocalDate.now());
        Operation operation2 = new Operation(2L,1L,new BigDecimal(50.00),false,true,true, LocalDate.now());
        Operation operation3 = new Operation(2L,1L,new BigDecimal(1000.00),false,true,true, LocalDate.now());
        //When
        operationRepository.save(operation1);
        operationRepository.save(operation2);
        operationRepository.save(operation3);
        //Then
        Assertions.assertEquals(3,operationDbService.getAllOperations().size());
        //CleanUp
        operationDbService.deleteByOperationId(1L);
        operationDbService.deleteByOperationId(38L);
        operationDbService.deleteByOperationId(38L);
    }
}
*/







