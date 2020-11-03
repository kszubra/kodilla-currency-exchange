package com.kodilla.currencyexchange.service.interfaces;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kodilla.currencyexchange.api.request.CurrencyExchangeRequest;
import com.kodilla.currencyexchange.api.request.RecordsFilterQuery;
import com.kodilla.currencyexchange.api.response.CurrencyExchangeResponse;
import com.kodilla.currencyexchange.api.snapshot.CurrencyExchangeRecordSnapshot;

public interface CurrencyExchangeApiService {

    BigDecimal getExchangeValue(CurrencyExchangeRequest request);

    Page<CurrencyExchangeResponse> getRecords(RecordsFilterQuery query, Pageable pageable);

    CurrencyExchangeRecordSnapshot getRecord(Long id);
}
