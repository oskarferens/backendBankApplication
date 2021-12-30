package com.bank.customer;

import com.bank.domain.Account;
import com.bank.domain.Customer;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerTestSuite {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    private Customer customer;
    private Account account;

    List<Account> accounts = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    @BeforeEach
    public void setup() {
        account = new Account(new BigDecimal(4563.65), 0L);
        customer = new Customer("Jan", "Kowalski","jankowalski@gmail.com","janPassword",false);
        customers.add(customer);
        accounts.add(account);
        customerRepository.save(customer);
        accountRepository.save(account);
    }

    @Test
    public void shouldSaveCustomer() {
        //When
        List<Customer> customers = customerRepository.findAll();
        //Then
        assertEquals(1, customers.size());
        //Cleanup
        customerRepository.delete(customer);
    }

    @Test
    public void shouldShowAllCustomers() {
        //Given
        customer = new Customer("Mirek", "Nowak","mirekNowak@gmail.com","mirekPassword",false);
        customers.add(customer);
        customerRepository.save(customer);
        //When
        List<Customer> customers = customerRepository.findAll();
        //Then
        assertEquals(2, customers.size());
        //Cleanup
        customerRepository.deleteAll();
    }

    @Test
    public void shouldUpdateUser() {
        //Given
        String firstName = customer.getFirstname();
        //When
        customer.setFirstname("Maciek");
        customerRepository.save(customer);
        //Then
        assertNotSame(firstName,customer.getFirstname());
        assertEquals("Maciek",customer.getFirstname());
        //Cleanup
        customerRepository.delete(customer);
    }

    @Test
    public void testDeleteUser() {
        //When
        customerRepository.delete(customer);
        //Then
        assertFalse(customerRepository.existsById(customer.getCustomerId()));
    }

    @Test
    public void testDeleteAccountDoesNotDeleteCustomer() {
        //When
        accountRepository.delete(account);
        //Then
        assertTrue(customerRepository.existsById(customer.getCustomerId()));
        //Cleanup
        customerRepository.delete(customer);
    }

    @Test
    public void shouldFindCustomerByFirstName() {
        //When
        customerRepository.findByFirstname("Jan");
        //Then
        assertEquals("Jan",customer.getFirstname());
        //Cleanup
        customerRepository.delete(customer);
    }
}
















