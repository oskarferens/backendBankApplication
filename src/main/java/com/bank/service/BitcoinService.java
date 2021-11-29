package com.bank.service;

import com.bank.client.BitcoinClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BitcoinService {

    @Autowired
    BitcoinClient bitcoinClient;

    /*public double showBitcoinValue() {
        Double bitcoinValue = bitcoinClient.getBitcoin()
                .stream()
                .filter(price -> price.getPrice().equals("BTC"))
                .findFirst().get().getPrice();
        return bitcoinValue;
    }*/
}
