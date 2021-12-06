package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "account_id", unique = true)
    private Long accountId;

    @NotNull
    @Column(name = "balance")
    private BigDecimal balance;

    @NotNull
    @Column(name = "bitcoinBalance")
    private Long bitcoinBalance;

    public Account( Long accountId, BigDecimal balance, Long bitcoinBalance) {
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToMany(
            targetEntity=Operation.class,
            mappedBy = "account",
            fetch = FetchType.LAZY
    )
    private List<Operation> operations;
}




