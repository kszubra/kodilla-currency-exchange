package com.kodilla.currencyexchange.api.response;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CurrencyExchangeResponse {

    private Long id;

    private LocalDateTime exchangeTime;

    private Currency from;

    private Currency to;

    private BigDecimal exchangedValue;
}
