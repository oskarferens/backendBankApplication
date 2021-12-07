package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "operationId", unique = true)
    private Long operationId;

    @NotNull
    @Column(name = "accountFrom")
    private Long accountFrom;

    @NotNull
    @Column(name = "accountTo")
    private Long accountTo;

    @NotNull
    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "internationalTransfer")
    private boolean internationalTransfer;

    @Column(name = "transfer")
    private boolean transfer;

    @Column(name = "operationComplete")
    private boolean operationComplete;

    @NotNull
    @Column(name = "operationDate")
    private LocalDate operationDate;

    public Operation (Long accountFrom, Long accountTo,
                      BigDecimal value, boolean transfer, boolean internationalTransfer,
                      boolean operationComplete, LocalDate operationDate) {
    }
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
}






















