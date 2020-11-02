package com.kodilla.currencyexchange.api.response;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
