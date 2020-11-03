package com.kodilla.currencyexchange.domain.model;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "currency_exchange_records")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CurrencyExchangeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyRecordId;

    @CreationTimestamp
    private LocalDateTime exchangeTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Currency baseCurrency;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Currency requestedCurrency;

    @NotNull
    private BigDecimal exchangedRate;

    @NotNull
    private BigDecimal exchangedValue;

    @NotNull
    private BigDecimal resultValue;
}
