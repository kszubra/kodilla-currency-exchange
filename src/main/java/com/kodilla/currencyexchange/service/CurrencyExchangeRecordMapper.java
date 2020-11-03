package com.kodilla.currencyexchange.service;

import org.springframework.stereotype.Component;

import com.kodilla.currencyexchange.api.command.CurrencyExchangeRecordAddCommand;
import com.kodilla.currencyexchange.api.response.CurrencyExchangeResponse;
import com.kodilla.currencyexchange.api.snapshot.CurrencyExchangeRecordSnapshot;
import com.kodilla.currencyexchange.domain.model.CurrencyExchangeRecord;

@Component
public class CurrencyExchangeRecordMapper {

    public CurrencyExchangeRecord mapToRecord(CurrencyExchangeRecordAddCommand command) {
        return CurrencyExchangeRecord.builder()
                .exchangedValue(command.getExchangedValue())
                .resultValue(command.getResultValue())
                .baseCurrency(command.getBaseCurrency())
                .exchangedRate(command.getExchangedRate())
                .requestedCurrency(command.getRequestedCurrency())
                .build();
    }

    public CurrencyExchangeRecordSnapshot mapToSnapshot(CurrencyExchangeRecord record) {
        return CurrencyExchangeRecordSnapshot.builder()
                .baseCurrency(record.getBaseCurrency())
                .currencyRecordId(record.getCurrencyRecordId())
                .exchangedRate(record.getExchangedRate())
                .exchangedValue(record.getExchangedValue())
                .exchangeTime(record.getExchangeTime())
                .requestedCurrency(record.getRequestedCurrency())
                .resultValue(record.getResultValue())
                .build();
    }

    public CurrencyExchangeResponse mapToResponse(CurrencyExchangeRecord record) {
        return CurrencyExchangeResponse.builder()
                .id(record.getCurrencyRecordId())
                .from(record.getBaseCurrency())
                .to(record.getRequestedCurrency())
                .exchangedValue(record.getExchangedValue())
                .exchangeTime(record.getExchangeTime())
                .build();
    }
}
