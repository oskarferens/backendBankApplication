package com.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "operations")
public class Operation {

    @Id
    @GeneratedValue
    @Column(name = "operationId", unique = true)
    @NotNull
    private Long operationId;

    @Column(name = "value")
    @NotNull
    private BigDecimal value;

    @Column(name = "internationalTransfer")
    @NotNull
    private double internationalTransfer;

    @Column(name = "transfer")
    @NotNull
    private double transfer;

    @Column(name = "operationComplete")
    @NotNull
    private boolean operationComplete;

}
