package com.bank.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ExchangeConfig{
    @Value("${exchange.api.endpoint.prod}")
    private String exchangeApiEndpoint;
}
