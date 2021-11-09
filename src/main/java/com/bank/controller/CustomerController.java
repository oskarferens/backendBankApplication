package com.bank.controller;

import com.bank.domain.Customer;
import com.bank.dto.CustomerDto;
import com.bank.exception.CustomerNotFoundException;
import com.bank.mapper.CustomerMapper;
import com.bank.service.CustomerDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerDbService customerDbService;
    @Autowired
    private final CustomerMapper customerMapper;

    @GetMapping("/getCustomers")
    public List<Customer> getAllCustomers() {
        return customerDbService.getAllCustomers();
    }

    @GetMapping("/getCustomerById/{customerId}")
    public Customer getCustomerById (@PathVariable Long customerId) {
        return customerDbService.getCustomerById(customerId);
    }

    @GetMapping("/getCustomerByName/{firstName}")
    public Customer getCustomerByFirstname (@PathVariable String firstName) {
        return customerDbService.getCustomerByFirstname(firstName);
    }

    @PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody Customer customer) {
        customerDbService.saveCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) {
        customerDbService.saveCustomer(customer);
    }

    @PatchMapping("/blockCustomer")
    public void blockCustomer(@RequestParam Long customerId) throws CustomerNotFoundException {
        customerDbService.blockCustomer(customerId);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam Long customerId) {
        customerDbService.deleteCustomerById(customerId);
    }

}






















