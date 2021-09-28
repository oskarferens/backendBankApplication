package com.bank.repository;

import com.bank.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    List<Customer> findAll();

    Optional<Customer> findById(Long id);
}

