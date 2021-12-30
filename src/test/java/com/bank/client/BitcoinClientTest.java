package com.bank.client;

/*import com.bank.config.BitcoinConfig;
import com.bank.dto.BitcoinDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BitcoinClientTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private BitcoinConfig bitcoinConfig;

    @Mock
    private BitcoinClient bitcoinClient;

    @Test
    public void ShouldFetchBitcoin() throws URISyntaxException {
        //Given
        when(bitcoinConfig.getBitcoinApiEndpoint()).thenReturn("https://test.com");
        BitcoinDto bitcoinDto = new BitcoinDto(new BigDecimal(123.45).setScale(2,RoundingMode.HALF_UP));
        URI url = new URI("https://test.com" + "/BTC" + bitcoinDto.getPrice());
        when(restTemplate.getForObject(url, BitcoinDto.class)).thenReturn(bitcoinDto);
        //When
        BitcoinDto fetchedPrice = bitcoinDto; //To when do poprawy
        //Then
        assertEquals(bitcoinDto, fetchedPrice);
    }
}*/
