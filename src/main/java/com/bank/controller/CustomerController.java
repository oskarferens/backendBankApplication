package com.bank.controller;

import com.bank.domain.Customer;
import com.bank.dto.CustomerDto;
import com.bank.mapper.CustomerMapper;
import com.bank.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final DbService service;
    private final CustomerMapper customerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCustomers")
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = service.getAllCustomers();
        return customerMapper.mapToCustomerDtoList(customers);
    }
}
