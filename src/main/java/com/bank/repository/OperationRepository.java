package com.bank.repository;

import com.bank.domain.Operation;
import org.hibernate.stat.Statistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();

    Optional<Operation> findById(Long operationId);

    Operation findByOperationDate(LocalDate date);

    @Override
    void deleteById(Long operationId);
}
