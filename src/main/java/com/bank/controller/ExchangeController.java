package com.bank.controller;

import com.bank.client.ExchangeClient;
import com.bank.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ExchangeController {

    @Autowired
    ExchangeClient exchangeClient;
    @Autowired
    ExchangeService exchangeservice;

    @GetMapping(value = "/EUR")
    public Double getEur() {
        return exchangeservice.showEURValue();
    }

    @GetMapping(value = "/USD")
    public Double getUsd() {
        return exchangeservice.showUSDValue();
    }

    @GetMapping(value = "/SEK")
    public Double getSek() {
        return exchangeservice.showSEKValue();
    }
}
