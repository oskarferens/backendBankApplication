package com.bank.service;

import com.bank.client.BitcoinClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BitcoinService {

    @Autowired
    BitcoinClient bitcoinClient;

    public BigDecimal showBTC() {
       return bitcoinClient.getBitcoin();
    }
}