package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long customerId;
    private Long accountId;
    private BigDecimal balance;
    private Long bitcoinBalance;
    private List<Long> operations = new ArrayList<>();

    public AccountDto(Long customerId, Long accountId, BigDecimal balance, Long bitcoinBalance) {
    }
}
