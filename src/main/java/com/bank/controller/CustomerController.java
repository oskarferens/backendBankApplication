package com.bank.controller;

import com.bank.domain.Customer;
import com.bank.dto.CustomerDto;
import com.bank.mapper.CustomerMapper;
import com.bank.service.CustomerDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerDbService customerDbService;
    private final CustomerMapper customerMapper;

    @GetMapping("getCustomers")
    public List<CustomerDto> getAllCustomers() {
        return customerMapper.mapToCustomerDtoList(
                customerDbService.getAllCustomers()
        );
    }

    @GetMapping("getCustomerById")
    public CustomerDto getCustomerById (@RequestParam Long customerId) {
        return customerMapper.mapToCustomerDto(
                customerDbService.getCustomerById(customerId)
        );
    }

    @PostMapping("createCustomer")
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        customerDbService.createCustomer(
                customerMapper.mapToCustomer(customerDto)
        );
    }

    @PutMapping("updateCustomer")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerMapper.mapToCustomerDto(customerDbService.saveCustomer(customerMapper.mapToCustomer(customerDto)
                )
        );
    }

    @DeleteMapping("deleteCustomer")
    public void deleteCustomer(@RequestParam Long customerId) {
        customerDbService.deleteCustomerById(customerId);
    }


}






















