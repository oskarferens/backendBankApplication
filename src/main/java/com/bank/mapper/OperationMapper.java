package com.bank.mapper;

import com.bank.domain.Operation;
import com.bank.dto.OperationDto;
import com.bank.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationMapper {

    private final OperationRepository operationRepository;

    public Operation mapToOperation(final OperationDto operationDto) {
        return new Operation(
                operationDto.getAccountFrom(),
                operationDto.getAccountTo(),
                operationDto.getValue(),
                operationDto.isTransfer(),
                operationDto.isInternationalTransfer(),
                operationDto.isOperationComplete(),
                operationDto.getOperationDate()
        );
    }

    public OperationDto mapToOperationDto(final Operation operation) {
        return new OperationDto(
                operation.getOperationId(),
                operation.getValue(),
                operation.isInternationalTransfer(),
                operation.isTransfer(),
                operation.isOperationComplete(),
                operation.getOperationDate(),
                operation.getAccountFrom(),
                operation.getAccountTo()
        );
    }

    public List<OperationDto> mapToOperationDtoList(final List<Operation> operationList) {
        return operationList.stream()
                .map(this::mapToOperationDto)
                .collect(Collectors.toList());
    }
}
