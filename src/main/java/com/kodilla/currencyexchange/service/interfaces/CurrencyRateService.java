package com.kodilla.currencyexchange.service.interfaces;

import java.math.BigDecimal;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import com.kodilla.currencyexchange.api.response.ExchangeRateResponse;

public interface CurrencyRateService {

    BigDecimal getExchangeRate(Currency base, Currency requested);
}
