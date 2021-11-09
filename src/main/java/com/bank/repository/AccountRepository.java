package com.bank.repository;

import com.bank.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

    Optional<Account> findById(Long id);

    Account findBalanceByAccountId (BigDecimal balance);

    @Override
    Account save (Account account);
}
