package com.bank.repository;

import com.bank.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

    Optional<Account> findById(Long accountId);

    @Override
    Account save (Account account);
}
