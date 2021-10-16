package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {
    private Long operationId;
    private double value;
    private double internationalTransfer;
    private double transfer;
}
