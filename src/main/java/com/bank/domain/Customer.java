package com.bank.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customerId", unique = true)
    @NotNull
    private Long customerId;

    @Column(name = "firstName")
    @NotNull
    private String name;

    @Column(name = "lastName")
    @NotNull
    private String lastname;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "isBlocked")
    @NotNull
    private Boolean isBlocked;

    @Column(name = "balance")
    @NotNull
    private Long balance;

    @Column(name = "loan")
    @NotNull
    private Boolean loan;
}

