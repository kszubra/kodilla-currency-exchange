package com.kodilla.currencyexchange.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ExchangeRateResponse {
    private String base;
    private String date;
    private Map<String, String> rates;
}
