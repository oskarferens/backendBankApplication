package com.bank.facade;

import com.bank.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeFacade {
    private final ExchangeService exchangeService;

    public double getEuro() {
        return exchangeService.showEURValue();
    }

    public double getUSD() {
        return exchangeService.showUSDValue();
    }

    public double getSEK() {
        return exchangeService.showSEKValue();
    }
}
