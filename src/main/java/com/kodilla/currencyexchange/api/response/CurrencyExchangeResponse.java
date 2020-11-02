package com.kodilla.currencyexchange.api.response;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencyExchangeResponse {

    private LocalDateTime exchangeTime;

    private Currency from;

    private Currency to;

    private BigDecimal exchangedValue;

    private BigDecimal resultValue;
}
