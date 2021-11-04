package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    /*@OneToMany(
            targetEntity = Account.class,
            mappedBy = "customers",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )*/

    @Id
    @GeneratedValue
    @Column(name = "customerId", unique = true)
    @NotNull
    private Long customerId;

    @Column(name = "firstName")
    @NotNull
    private String firstname;

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
}

