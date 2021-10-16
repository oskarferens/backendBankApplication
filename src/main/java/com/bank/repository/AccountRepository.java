package com.bank.repository;

import com.bank.domain.Account;
import com.bank.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

    Optional<Account> findById(Long accountId);

    Optional<Customer> findByCustomerId(Long customerId);

    @Override
    Account save (Account account);
}
