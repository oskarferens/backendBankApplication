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
            mappedBy = "accounts",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @ManyToOne(
            targetEntity = Customer.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL

    )

    @Id
    @GeneratedValue
    @Column(name = "accountId", unique = true)
    @NotNull
    private Long accountId;

    @Column(name = "balance")
    @NotNull
    private BigDecimal balance;

    @Column(name = "bitcoinBalance")
    @NotNull
    private Long bitcoinBalance;
}
