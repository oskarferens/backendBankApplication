package com.bank.repository;

import com.bank.domain.Account;
import com.bank.domain.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Override
    List<Account> findAll();

    Optional<Account> findById(Long id);

    @Override
    Account save(Account account);

    //List<Operation> findAllByOperationStat(Long aLong);

}
