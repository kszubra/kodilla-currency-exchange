package com.kodilla.currencyexchange.domain.repository;

import com.kodilla.currencyexchange.domain.model.CurrencyExchangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyExchangeRecordRepository extends CrudRepository<CurrencyExchangeRecord, Long>, JpaSpecificationExecutor<CurrencyExchangeRecord> {
}
