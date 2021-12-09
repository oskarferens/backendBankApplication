package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
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

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    public Customer(String firstname, String lastname, String email, String password, Boolean isBlocked) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.isBlocked = isBlocked;
    }
}




















