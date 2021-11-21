package com.bank.service;

import com.bank.domain.Customer;
import com.bank.exception.CustomerNotFoundException;
import com.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDbService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByFirstname(String firstName) {
        return customerRepository.findByFirstname(firstName);
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

    public void blockCustomer(Long customerId) throws CustomerNotFoundException {
        Optional<Customer> customerToBlock = customerRepository.findById(customerId);
        Customer blockedCustomer = customerToBlock.orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + customerId + " not found"));
        if (!blockedCustomer.getIsBlocked()) {
            blockedCustomer.setIsBlocked(true);
        }
        customerRepository.save(blockedCustomer);
    }

}
