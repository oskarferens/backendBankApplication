package com.bank.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operations")
public class Operation {

    @ManyToOne(
            targetEntity = Account.class,
            mappedBy = "operations",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )

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
