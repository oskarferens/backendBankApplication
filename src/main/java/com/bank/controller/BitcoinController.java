package com.bank.controller;

import com.bank.client.BitcoinClient;
import com.bank.service.BitcoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class BitcoinController {

    @Autowired
    BitcoinClient bitcoinClient;
    @Autowired
    BitcoinService bitcoinService;

    @GetMapping(value = "/BTC")
    public BigDecimal getBTC() {
        return bitcoinService.showBTC();
    }
}
