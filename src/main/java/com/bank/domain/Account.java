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

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer customer;

    @OneToMany(
            targetEntity=Operation.class,
            mappedBy = "account"
    )
    private List<Operation> operations = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "accountId", unique = true)
    private Long accountId;

    @NotNull
    @Column(name = "customerId")
    private Long customerId;

    @NotNull
    @Column(name = "balance")
    private BigDecimal balance;

    @NotNull
    @Column(name = "bitcoinBalance")
    private Long bitcoinBalance;

    public Account(Long customerId, Long accountId, BigDecimal balance, Long bitcoinBalance) {
    }

    public Customer getCustomerById() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}




