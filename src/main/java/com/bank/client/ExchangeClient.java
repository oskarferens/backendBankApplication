package com.bank.client;

import com.bank.config.ExchangeConfig;
import com.bank.dto.ExchangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class ExchangeClient {

    private final RestTemplate restTemplate;
    private final ExchangeConfig exchangeConfig;

    public ExchangeDto currency() {
        URI url = UriComponentsBuilder.fromHttpUrl(exchangeConfig.getExchangeApiEndpoint())
                .build()
                .encode()
                .toUri();

        return restTemplate.getForObject(url, ExchangeDto.class);
    }



}
