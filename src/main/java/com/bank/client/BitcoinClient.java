package com.bank.client;

import com.bank.dto.BitcoinDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BitcoinClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeClient.class);

    private final RestTemplate restTemplate = new RestTemplate();

    public Double getBitcoin() {
        
        URI url = UriComponentsBuilder.fromHttpUrl
                ("https://api.nomics.com/v1/currencies/ticker?key=96af54cf19b38ec31bf8e9331977e8ebf863a77d&ids=BTC&convert=PLN")
                .build()
                .encode()
                .toUri();

        BitcoinDto boardsResponse = restTemplate.getForObject(url, BitcoinDto.class);
        return boardsResponse.getPrice();
        /*try {
            BitcoinDto boardsResponse = restTemplate.getForObject(url, BitcoinDto.class);
            return boardsResponse;
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }*/
    }
}
