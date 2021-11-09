package com.bank.dto;

import com.bank.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isBlocked;
    private List<Account> accounts = new ArrayList<>();

    public CustomerDto(Long customerId, String firstname, String lastname, String email, String password, Boolean isBlocked) {
    }
}

