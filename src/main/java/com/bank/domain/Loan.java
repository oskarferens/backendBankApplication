package com.bank.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Loan {
    @Id
    @GeneratedValue
    @Column(name = "loanId", unique = true)
    @NotNull
    private Long loanId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @NotNull
    @Column(name = "dateOfLoan")
    private LocalDate dateOfLoan;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @Column(name = "paymentsLeft")
    private Long paymentsLeft;

    @NotNull
    @Column(name = "paymentsQuantity")
    private Long paymentsQuantity;

    @NotNull
    @Column(name = "paymentDelay")
    private Boolean paymentDelay;
}
