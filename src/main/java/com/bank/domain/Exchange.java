package com.bank.domain;

import com.bank.dto.RatesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Exchange {

    RatesDto rates;
    private String base;
    private String date;

}
