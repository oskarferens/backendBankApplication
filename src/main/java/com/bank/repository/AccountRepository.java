package com.bank.repository;

import com.bank.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {


    List<Account> findAll();

    Account findAccountByAccountId (Long accountId);

    Account findByBalance (BigDecimal balance);

    @Override
    Account save (Account account);
}
