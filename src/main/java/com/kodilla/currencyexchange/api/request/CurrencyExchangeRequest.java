package com.kodilla.currencyexchange.api.request;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencyExchangeRequest {

    private Currency from;

    private Currency to;

    private BigDecimal value;
}
