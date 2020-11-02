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

import java.net.URI;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class SimpleCurrencyRateService implements CurrencyRateService {
    private final RestTemplate restTemplate;

    @Override
    public ExchangeRateResponse getExchangeRate(Currency base, Currency requested) {
        URI url = UriComponentsBuilder.fromHttpUrl(
                String.format("https://api.exchangeratesapi.io/latest?base=%s&symbols=%s", base.toString(), requested.toString())
        )
                .queryParam("format", "json")
                .build().encode().toUri();

        try{
            ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
            return Optional.ofNullable(response).orElse(new ExchangeRateResponse());
        } catch(RestClientException e) {
            log.error(e.getMessage(), e);
            return new ExchangeRateResponse();
        }
    }
}
