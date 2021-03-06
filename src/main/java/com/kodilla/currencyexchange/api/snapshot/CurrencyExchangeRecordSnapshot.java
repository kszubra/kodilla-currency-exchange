package com.kodilla.currencyexchange.api.snapshot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.kodilla.currencyexchange.api.enumeration.Currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class CurrencyExchangeRecordSnapshot {

    private Long currencyRecordId;

    private LocalDateTime exchangeTime;

    private Currency baseCurrency;

    private Currency requestedCurrency;

    private BigDecimal exchangedRate;

    private BigDecimal exchangedValue;

    private BigDecimal resultValue;
}
