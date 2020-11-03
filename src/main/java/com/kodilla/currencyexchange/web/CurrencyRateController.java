package com.kodilla.currencyexchange.web;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodilla.currencyexchange.api.request.CurrencyExchangeRequest;
import com.kodilla.currencyexchange.api.request.RecordsFilterQuery;
import com.kodilla.currencyexchange.api.response.CurrencyExchangeResponse;
import com.kodilla.currencyexchange.api.snapshot.CurrencyExchangeRecordSnapshot;
import com.kodilla.currencyexchange.service.interfaces.CurrencyExchangeApiService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyExchangeApiService apiService;

    @GetMapping
    public BigDecimal getExchangeRate(@Valid CurrencyExchangeRequest request) {
        return apiService.getExchangeValue(request);
    }

    @GetMapping("/records")
    public Page<CurrencyExchangeResponse> getRecords(@Valid RecordsFilterQuery query, Pageable pageable) {
        return apiService.getRecords(query, pageable);
    }

    @GetMapping("/records/{id}")
    public CurrencyExchangeRecordSnapshot getRecord(@PathVariable Long id) {
        return apiService.getRecord(id);
    }
}
