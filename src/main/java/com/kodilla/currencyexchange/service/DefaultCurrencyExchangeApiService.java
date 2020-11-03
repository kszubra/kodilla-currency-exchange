package com.kodilla.currencyexchange.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodilla.currencyexchange.api.command.CurrencyExchangeRecordAddCommand;
import com.kodilla.currencyexchange.api.enumeration.Currency;
import com.kodilla.currencyexchange.api.request.CurrencyExchangeRequest;
import com.kodilla.currencyexchange.api.request.RecordsFilterQuery;
import com.kodilla.currencyexchange.api.response.CurrencyExchangeResponse;
import com.kodilla.currencyexchange.api.snapshot.CurrencyExchangeRecordSnapshot;
import com.kodilla.currencyexchange.service.interfaces.CurrencyExchangeApiService;
import com.kodilla.currencyexchange.service.interfaces.CurrencyExchangeRecordService;
import com.kodilla.currencyexchange.service.interfaces.CurrencyRateService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultCurrencyExchangeApiService implements CurrencyExchangeApiService {

    private final CurrencyExchangeRecordService recordService;
    private final CurrencyRateService rateService;

    @Override
    @Transactional
    public BigDecimal getExchangeValue(CurrencyExchangeRequest request) {
        Currency baseCurrency = request.getFrom();
        Currency requestedCurrency = request.getTo();
        BigDecimal value = request.getValue();
        BigDecimal exchangeRate = rateService.getExchangeRate(baseCurrency, requestedCurrency);
        BigDecimal result = value.multiply(exchangeRate).setScale(4, RoundingMode.HALF_EVEN);

        CurrencyExchangeRecordAddCommand command = CurrencyExchangeRecordAddCommand.builder()
                .baseCurrency(baseCurrency)
                .exchangedRate(exchangeRate)
                .exchangedValue(value)
                .requestedCurrency(requestedCurrency)
                .resultValue(result)
                .build();
        CurrencyExchangeRecordSnapshot snapshot = recordService.addRecord(command);
        log.info(snapshot.toString());

        return result;
    }

    @Override
    public Page<CurrencyExchangeResponse> getRecords(RecordsFilterQuery query, Pageable pageable) {
        return recordService.getRecords(query, pageable);
    }

    @Override
    public CurrencyExchangeRecordSnapshot getRecord(Long id) {
        return recordService.getById(id);
    }
}
