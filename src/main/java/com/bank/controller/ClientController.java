package com.bank.controller;


import com.bank.dto.CustomerDto;
import com.bank.domain.Customer;
import com.bank.mapper.CustomerMapper;
import com.bank.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private DbService service;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping(value = "/customers")
    public List<CustomerDto> getCustomers() {
        List<Customer> customerList = service.getAllCustomers();
        return customerMapper.mapToCustomerDtoList(customerList);
    }

}
