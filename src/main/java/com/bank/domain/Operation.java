package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operations")
public class Operation {

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "operationId", unique = true)
    private Long operationId;

    @NotNull
    @Column(name = "value")
    private BigDecimal value;

    @NotNull
    @Column(name = "internationalTransfer")
    private double internationalTransfer;

    @NotNull
    @Column(name = "transfer")
    private double transfer;

    @NotNull
    @Column(name = "operationComplete")
    private boolean operationComplete;

    @NotNull
    @Column(name = "operationDate")
    private LocalDate operationDate;

    public Operation(Long operationId, BigDecimal value, double transfer,
                     double internationalTransfer, boolean operationComplete,
                     LocalDate operationDate) {
    }
}
