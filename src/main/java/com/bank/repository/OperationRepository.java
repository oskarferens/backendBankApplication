package com.bank.repository;

import com.bank.domain.Operation;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OperationRepository extends CrudRepository<Operation, Long> {

    @Override
    List<Operation> findAll();

    Operation findByOperationId(Long operationId);

    @Override
    Operation save(Operation operation);

}
