package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {
    private Long operationId;
    private Long accountFrom;
    private Long accountTo;
    private BigDecimal value;
    private boolean internationalTransfer;
    private boolean transfer;
    private boolean operationComplete;
    private LocalDate operationDate;

    public OperationDto(Long operationId, BigDecimal value,
                        boolean internationalTransfer, boolean transfer, boolean operationComplete,
                        LocalDate operationDate, Long accountFrom, Long accountTo) {
    }
}
