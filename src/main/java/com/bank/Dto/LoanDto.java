package com.bank.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private Long loanId;
    private Long customerId;
    private LocalDate dateOfLoan;
    private BigDecimal price;
    private Long paymentsLeft;
    private Long paymentsQuantity;
    private Boolean paymentDelay;
}
