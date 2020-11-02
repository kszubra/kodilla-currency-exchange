package com.kodilla.currencyexchange.domain.repository;

import com.kodilla.currencyexchange.domain.model.CurrencyExchangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRecordRepository extends JpaRepository<CurrencyExchangeRecord, Long> {
}
