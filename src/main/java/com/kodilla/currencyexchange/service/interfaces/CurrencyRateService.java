package com.kodilla.currencyexchange.service.interfaces;

import com.kodilla.currencyexchange.api.enumeration.Currency;

import java.math.BigDecimal;

public interface CurrencyRateService {

    BigDecimal getExchangeRate(Currency base, Currency requested);
}
