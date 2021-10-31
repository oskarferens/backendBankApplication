package com.bank.tests;

import com.bank.domain.Customer;
import com.bank.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RepoTestSuite {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testCreateCustomer(){
        //Given
        Customer customer = new Customer();
        //When

        //Then
        assertEquals();
        //CleanUp
        //customerRepository.deleteById();
    }

}
