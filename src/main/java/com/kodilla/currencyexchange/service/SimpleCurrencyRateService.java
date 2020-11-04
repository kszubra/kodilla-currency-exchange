package com.kodilla.currencyexchange.service;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import com.kodilla.currencyexchange.api.response.ExchangeRateResponse;
import com.kodilla.currencyexchange.service.interfaces.CurrencyRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;

@Component
@AllArgsConstructor
@Slf4j
public class SimpleCurrencyRateService implements CurrencyRateService {
    private final RestTemplate restTemplate;

    @Override
    public BigDecimal getExchangeRate(Currency base, Currency requested) {
        URI url = UriComponentsBuilder.fromHttpUrl(
                String.format("https://api.exchangeratesapi.io/latest?base=%s&symbols=%s", base.toString(), requested.toString())
        )
                .queryParam("format", "json")
                .build().encode().toUri();

        try{
            ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
            Double value = Double.parseDouble(response.getRates().get(requested.toString()));
            BigDecimal result = BigDecimal.valueOf(value).setScale(4, RoundingMode.HALF_EVEN);
            return result;
        } catch(RestClientException e) {
            log.error(e.getMessage(), e);
            return BigDecimal.ZERO;
        }
    }
}
