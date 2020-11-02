package com.kodilla.currencyexchange.web;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import com.kodilla.currencyexchange.api.response.ExchangeRateResponse;
import com.kodilla.currencyexchange.service.interfaces.CurrencyRateService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyRateService rateService;

    @GetMapping
    public ExchangeRateResponse getExchangeRate(@RequestParam Currency base, @RequestParam Currency requested) {
        ExchangeRateResponse response = rateService.getExchangeRate(base, requested);
        System.out.println(response.toString());
        System.out.println(response.getRates().get(requested.toString()));
        return response;
    }
}
