package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @OneToMany(
            targetEntity = Operation.class,
            mappedBy = "accounts"
    )

    @ManyToOne(
            targetEntity = Customer.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )

    @NotNull
    @Column(name = "customerId")
    private Long customerId;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "accountId", unique = true)
    private Long accountId;

    @NotNull
    @Column(name = "balance", scale = 2)
    private BigDecimal balance;

    @NotNull
    @Column(name = "bitcoinBalance")
    private Long bitcoinBalance;
}
