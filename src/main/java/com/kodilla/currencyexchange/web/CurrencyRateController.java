package com.kodilla.currencyexchange.web;

import com.kodilla.currencyexchange.api.request.CurrencyExchangeRequest;
import com.kodilla.currencyexchange.service.interfaces.CurrencyExchangeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyExchangeApiService apiService;

    @GetMapping
    public BigDecimal getExchangeRate(@Valid CurrencyExchangeRequest request) {
        return apiService.getExchangeValue(request);
    }
}
