package com.bank.controller;

import com.bank.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitWebConfig
@WebMvcTest(CustomerController.class)
class CustomerControllerTests {
    @Test
    void shouldShowAllCustomers() throws Exception {
        //Given
        List<Customer> listOfCustomers = List.of(new Customer
                (3L,"Kuba","Kowalski","KubaKowalski@gmail.com","Kuba123",false));
        //When

        //Then

    }

    @Test
    void shouldShow() throws Exception {
        //Given

        //When

        //Then

    }

    @Test
    void should() throws Exception {
        //Given

        //When

        //Then

    }
}