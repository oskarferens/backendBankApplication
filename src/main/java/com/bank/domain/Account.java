package com.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "accounts")
public class Account {

    @Column(name = "customerId")
    @NotNull
    private Long customerId;

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
