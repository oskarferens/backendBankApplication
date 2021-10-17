package com.bank.repository;

import com.bank.domain.Operation;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();

    Optional<Operation> findById(Long id);

    @Override
    Operation save(Operation operation);

}
