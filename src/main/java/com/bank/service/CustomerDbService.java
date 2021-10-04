package com.bank.service;

import com.bank.domain.Customer;
import com.bank.exception.CustomerNotFoundException;
import com.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDbService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() ->
                new CustomerNotFoundException("Customer with id: " + customerId + "doesn't exsist"));
    }

    public Customer saveCustomer(final Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById (Long customerId) {
        customerRepository.deleteById(customerId);
    }

}
