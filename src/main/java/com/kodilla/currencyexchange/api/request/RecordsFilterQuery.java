package com.kodilla.currencyexchange.api.request;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.kodilla.currencyexchange.api.enumeration.Currency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class RecordsFilterQuery {

    @PastOrPresent
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdFrom;

    @PastOrPresent
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTo;

    private Set<Currency> fromCurrencies;

    private Set<Currency> toCurrencies;
}
