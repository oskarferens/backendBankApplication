package com.bank.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isBlocked;
    private Long balance;
    private Boolean loan;
}

