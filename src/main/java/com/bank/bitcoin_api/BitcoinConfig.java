package com.bank.bitcoin_api;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BitcoinConfig {
    //@Value () tu bedzie cos z stylu ("${bitcoin.api.endpoint.prod}")
    private String BitcoinApiEndpoint;
}
