package com.kodilla.currencyexchange.service;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import com.kodilla.currencyexchange.api.request.CurrencyExchangeRequest;
import com.kodilla.currencyexchange.service.interfaces.CurrencyExchangeApiService;
import com.kodilla.currencyexchange.service.interfaces.CurrencyRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultCurrencyExchangeApiService implements CurrencyExchangeApiService {

    private final CurrencyRateService rateService;

    @Override
    public BigDecimal getExchangeValue(CurrencyExchangeRequest request) {
        Currency baseCurrency = request.getFrom();
        Currency requestedCurrency = request.getTo();
        BigDecimal value = request.getValue();
        BigDecimal exchangeRate = rateService.getExchangeRate(baseCurrency, requestedCurrency);
        BigDecimal result = value.multiply(exchangeRate).setScale(4, RoundingMode.HALF_EVEN);

        return result;
    }
}
