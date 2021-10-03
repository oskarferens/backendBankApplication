package com.bank.controller;

import com.bank.domain.Customer;
import com.bank.dto.CustomerDto;
import com.bank.mapper.CustomerMapper;
import com.bank.service.CustomerDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerDbService customerDbService;
    private final CustomerMapper customerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCustomers")
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerDbService.getAllCustomers();
        return customerMapper.mapToCustomerDtoList(customers);
    }
}
