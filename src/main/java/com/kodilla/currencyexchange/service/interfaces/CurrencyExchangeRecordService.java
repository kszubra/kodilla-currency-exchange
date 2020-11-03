package com.kodilla.currencyexchange.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kodilla.currencyexchange.api.command.CurrencyExchangeRecordAddCommand;
import com.kodilla.currencyexchange.api.request.RecordsFilterQuery;
import com.kodilla.currencyexchange.api.response.CurrencyExchangeResponse;
import com.kodilla.currencyexchange.api.snapshot.CurrencyExchangeRecordSnapshot;

public interface CurrencyExchangeRecordService {

    CurrencyExchangeRecordSnapshot addRecord(CurrencyExchangeRecordAddCommand command);

    CurrencyExchangeRecordSnapshot getById(Long id);

    Page<CurrencyExchangeResponse> getRecords(RecordsFilterQuery query, Pageable pageable);

}
