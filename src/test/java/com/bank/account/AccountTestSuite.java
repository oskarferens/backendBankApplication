package com.bank.account;

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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountTestSuite {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    public static final Account ACCOUNT = new Account(new BigDecimal(4563.65), 0L);
    public static final Customer CUSTOMER = new Customer("Jan", "Kowalski", "jankowalski@gmail.com", "janPassword", false);
    private Customer customer;
    private Account account;

    List<Account> accounts = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    @BeforeEach
    public void setup() {
        account = ACCOUNT;
        customer = CUSTOMER;
        customers.add(customer);
        accounts.add(account);
        customerRepository.save(customer);
        accountRepository.save(account);
    }

    @Test
    public void shouldSaveAccount() {
        //When
        List<Account> accounts = accountRepository.findAll();
        //Then
        assertEquals(1, accounts.size());
        //Cleanup


    }
    @Test
    public void shouldGetAccountByCustomerId() {
        //Given
        //When
        //Then
        //Cleanup
    }
    @Test
    public void shouldShowAllAccounts() {
        //Given
        //When
        //Then
        //Cleanup
    }
    @Test
    public void shouldShowAllCustomerAccounts() {
        //Given
        //When
        //Then
        //Cleanup
    }
    @Test
    public void shouldDeleteAccountWithoutDeletingCustomer() {
        //Given
        //When
        //Then
        //Cleanup
    }
    @Test
    public void shouldShowCustomerBalance () {
        //Given
        //When
        //Then
        //Cleanup
    }
}
