package com.bank.facade;

import com.bank.service.BitcoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BitcoinFacade {

    private final BitcoinService bitcoinService;

    public BigDecimal showBitcoin () {
        return bitcoinService.showBTC();
    }
}
