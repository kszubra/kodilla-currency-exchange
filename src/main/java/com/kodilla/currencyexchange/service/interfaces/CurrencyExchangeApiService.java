package com.kodilla.currencyexchange.service.interfaces;

import com.kodilla.currencyexchange.api.request.CurrencyExchangeRequest;

import java.math.BigDecimal;

public interface CurrencyExchangeApiService {

    BigDecimal getExchangeValue(CurrencyExchangeRequest request);
}
