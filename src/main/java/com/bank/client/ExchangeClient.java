package com.bank.client;

import com.bank.domain.Rates;
import com.bank.domain.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeClient.class);

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Rates> getAllCurrencies() {

        URI url = UriComponentsBuilder.fromHttpUrl("https://api.nbp.pl/api/exchangerates/tables/c?format=json")
                .build()
                .encode()
                .toUri();

        try {
            Currency[] boardsResponse = restTemplate.getForObject(url, Currency[].class);
            return Optional.ofNullable(boardsResponse)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList())
                    .stream()
                    .flatMap(currency -> currency.getRates()
                            .stream())
                    .collect(Collectors.toList());

        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}

