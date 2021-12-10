package com.bank.facade;

import com.bank.domain.Customer;
import com.bank.service.CustomerDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerFacade {

    private final CustomerDbService customerDbService;

    public List<Customer> getAllCustomers() {
        return customerDbService.getAllCustomers();
    }
    public Customer getCustomerByFirstname(String firstname) {
        return customerDbService.getCustomerByFirstname(firstname);
    }

    public Boolean createCustomer(Customer customer) {
        return customerDbService.saveCustomer(customer) !=null;
    }

    public Customer getCustomerById(Long customerId) {
        return customerDbService.getCustomerById(customerId);
    }

    public void editCustomer(Customer customer) {
        customerDbService.saveCustomer(customer);
    }

    public void deleteCustomer(Long customerId) {
        customerDbService.deleteCustomerById(customerId);
    }

    public void blockCustomer(Long customerId) {
        customerDbService.blockCustomer(customerId);
    }







}
