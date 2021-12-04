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
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "operationId", unique = true)
    private Long operationId;

    @Column(name = "accountFrom")
    private Long accountFrom;

    @Column(name = "accountTo")
    private Long accountTo;

    @NotNull
    @Column(name = "value")
    private BigDecimal value;

    @NotNull
    @Column(name = "internationalTransfer")
    private boolean internationalTransfer;

    @NotNull
    @Column(name = "transfer")
    private boolean transfer;

    @NotNull
    @Column(name = "operationComplete")
    private boolean operationComplete;

    @NotNull
    @Column(name = "operationDate")
    private LocalDate operationDate;

    public Operation (Long operationId, BigDecimal value, boolean transfer,
                     boolean internationalTransfer, boolean operationComplete,
                     LocalDate operationDate,Long accountFrom, Long accountTo) {
    }

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
