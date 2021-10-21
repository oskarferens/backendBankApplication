package com.bank.repository;

import com.bank.domain.Account;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

    Account findAccountByAccountId(Long accountId);

    //Optional<Customer> findByAccountByCustomerId(Long customerId);

    @Override
    Account save (Account account);
}
