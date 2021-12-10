package com.bank.controller;

import com.bank.client.ExchangeClient;
import com.bank.facade.ExchangeFacade;
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

    private final ExchangeFacade exchangeFacade;

    @GetMapping(value = "/EUR")
    public Double getEur() {
        return exchangeFacade.getEuro();
    }

    @GetMapping(value = "/USD")
    public Double getUsd() {
        return exchangeFacade.getUSD();
    }

    @GetMapping(value = "/SEK")
    public Double getSek() {
        return exchangeFacade.getSEK();
    }
}
