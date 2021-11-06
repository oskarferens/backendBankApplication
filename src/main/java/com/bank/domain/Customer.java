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

    @OneToMany(
            targetEntity = Account.class,
            mappedBy = "customerId",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )

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
}

