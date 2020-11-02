package com.kodilla.currencyexchange.service.interfaces;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import com.kodilla.currencyexchange.api.response.ExchangeRateResponse;

public interface CurrencyRateService {

    ExchangeRateResponse getExchangeRate(Currency base, Currency requested);
}
