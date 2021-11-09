package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @OneToMany(
            targetEntity=Account.class,
            mappedBy = "customer"
    )
    private List<Account> accounts = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "customerId", unique = true)
    private Long customerId;

    @NotNull
    @Column(name = "firstName")
    private String firstname;

    @NotNull
    @Column(name = "lastName")
    private String lastname;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "isBlocked")
    private Boolean isBlocked;

    public Customer(Long customerId, String firstName, String lastName, String email, String password, Boolean isBlocked) {
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

