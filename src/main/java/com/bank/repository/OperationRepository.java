package com.bank.repository;

import com.bank.domain.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();

    Operation findByOperationId(Long operationId);

    @Override
    Operation save(Operation operation);

    Operation findByOperationDate(LocalDate date);

}
