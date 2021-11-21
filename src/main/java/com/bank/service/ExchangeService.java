package com.bank.service;

import com.bank.client.ExchangeClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ExchangeService {

    @Autowired
    ExchangeClient exchangeClient;

    public double showEURValue() {
        Double euroValue = exchangeClient.getAllCurrencies()
                .stream()
                .filter(rates -> rates.getCode()
                        .equals("EUR"))
                .findFirst().get().getBid();
        return euroValue;
    }

    public double showUSDValue() {
        Double usdValue = exchangeClient.getAllCurrencies()
                .stream()
                .filter(rates -> rates.getCode()
                        .equals("USD"))
                .findFirst().get().getBid();
        return usdValue;
    }

    public double showSEKValue() {
        Double sekValue = exchangeClient.getAllCurrencies()
                .stream()
                .filter(rates -> rates.getCode()
                        .equals("SEK"))
                .findFirst().get().getBid();
        return sekValue;
    }
}
















