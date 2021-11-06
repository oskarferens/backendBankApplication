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
    private BigDecimal value;
    private double internationalTransfer;
    private double transfer;
    private boolean operationComplete;
    private LocalDate operationDate;
}
