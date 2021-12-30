package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "accountid", unique = true)
    private Long accountId;

    @NotNull
    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "bitcoinBalance")
    private Long bitcoinBalance;

    /*@Column(name = "operationStat")
    private Long operationStat;*/

    public Account( BigDecimal balance, Long bitcoinBalance) {
        this.balance = balance;
        this.bitcoinBalance = bitcoinBalance;
    }

    @OneToMany(mappedBy = "account")
    private List<Operation> operations;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}

























