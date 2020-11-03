package com.kodilla.currencyexchange.api.command;

import java.math.BigDecimal;

import com.kodilla.currencyexchange.api.enumeration.Currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CurrencyExchangeRecordAddCommand {

    private Currency baseCurrency;

    private Currency requestedCurrency;

    private BigDecimal exchangedRate;

    private BigDecimal exchangedValue;

    private BigDecimal resultValue;
}
