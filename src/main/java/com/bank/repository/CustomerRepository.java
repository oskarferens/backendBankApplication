package com.bank.repository;

import com.bank.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    @Override
    Customer save(Customer customer);

    Customer findByFirstname(String firstname);
}

//Fixed, While using CrudRepository of Spring , we have to append the
// propertyname correctly after findBy otherwise it will give you exception "No Property Found for Type”

