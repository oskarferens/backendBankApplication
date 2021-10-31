package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long accountId;
    private BigDecimal balance;
    private Long bitcoinBalance;
}
