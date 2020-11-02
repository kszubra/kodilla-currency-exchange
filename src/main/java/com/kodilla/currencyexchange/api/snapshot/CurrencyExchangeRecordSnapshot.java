package com.kodilla.currencyexchange.api.snapshot;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencyExchangeRecordSnapshot {

    private Long id;

    private LocalDateTime exchangeTime;

    private Currency from;

    private Currency to;

    private BigDecimal exchangedValue;

    private BigDecimal resultValue;
}
