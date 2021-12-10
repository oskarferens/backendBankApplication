package com.bank.controller;

import com.bank.facade.BitcoinFacade;
import lombok.RequiredArgsConstructor;
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

    private final BitcoinFacade bitcoinFacade;

    @GetMapping(value = "/BTC")
    public BigDecimal getBTC() {
        return bitcoinFacade.showBitcoin();
    }
}
