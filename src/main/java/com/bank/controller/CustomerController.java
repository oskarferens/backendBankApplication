package com.bank.controller;

import com.bank.domain.Customer;
import com.bank.exception.CustomerNotFoundException;
import com.bank.facade.CustomerFacade;
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

    private final CustomerFacade customerFacade;

    @GetMapping("/getCustomers")
    public List<Customer> getAllCustomers() {
        return customerFacade.getAllCustomers();
    }

    @GetMapping("/getCustomerById/{customerId}")
    public Customer getCustomerById (@PathVariable Long customerId) {
        return customerFacade.getCustomerById(customerId);
    }

    @GetMapping("/getCustomerByName/{firstName}")
    public Customer getCustomerByFirstname (@PathVariable String firstName) {
        return customerFacade.getCustomerByFirstname(firstName);
    }

    @PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody Customer customer) {
        customerFacade.createCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) {
        customerFacade.editCustomer(customer);
    }

    @PatchMapping("/blockCustomer")
    public void blockCustomer(@RequestParam Long customerId) throws CustomerNotFoundException {
        customerFacade.blockCustomer(customerId);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam Long customerId) {
        customerFacade.deleteCustomer(customerId);
    }
}






















