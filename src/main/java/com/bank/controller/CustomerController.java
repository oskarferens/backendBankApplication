package com.bank.controller;

import com.bank.dto.CustomerDto;
import com.bank.exception.CustomerNotFoundException;
import com.bank.mapper.CustomerMapper;
import com.bank.service.CustomerDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<CustomerDto> getAllCustomers() {
        return customerMapper.mapToCustomerDtoList(
                customerDbService.getAllCustomers()
        );
    }

    @GetMapping("/getCustomerById")
    public CustomerDto getCustomerById (@RequestParam Long customerId) {
        return customerMapper.mapToCustomerDto(
                customerDbService.getCustomerById(customerId)
        );
    }

    @GetMapping("/getCustomerByName/{firstName}")
    public CustomerDto getCustomerByFirstname (@PathVariable String firstName) {
        return customerMapper.mapToCustomerDto(customerDbService.getCustomerByFirstname(firstName)
        );
    }

    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        customerDbService.createCustomer(
                customerMapper.mapToCustomer(customerDto)
        );
    }

    @PutMapping("/updateCustomer")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerMapper.mapToCustomerDto(customerDbService.saveCustomer(customerMapper.mapToCustomer(customerDto)
                )
        );
    }

    @PatchMapping("/blockCustomer")
    public void blockUser(@RequestParam Long customerId) throws CustomerNotFoundException {
        customerDbService.blockCustomer(customerId);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam Long customerId) {
        customerDbService.deleteCustomerById(customerId);
    }

}






















