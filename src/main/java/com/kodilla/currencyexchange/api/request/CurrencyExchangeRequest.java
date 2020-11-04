package com.kodilla.currencyexchange.api.request;

import com.kodilla.currencyexchange.api.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class CurrencyExchangeRequest {

    @NotNull
    private Currency from;

    @NotNull
    private Currency to;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal value;
}
