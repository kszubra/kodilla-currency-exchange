package com.kodilla.currencyexchange.service;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodilla.currencyexchange.api.command.CurrencyExchangeRecordAddCommand;
import com.kodilla.currencyexchange.api.enumeration.Currency;
import com.kodilla.currencyexchange.api.request.RecordsFilterQuery;
import com.kodilla.currencyexchange.api.response.CurrencyExchangeResponse;
import com.kodilla.currencyexchange.api.snapshot.CurrencyExchangeRecordSnapshot;
import com.kodilla.currencyexchange.domain.model.CurrencyExchangeRecord;
//import com.kodilla.currencyexchange.domain.model.CurrencyExchangeRecord_;
import com.kodilla.currencyexchange.domain.repository.CurrencyExchangeRecordRepository;
import com.kodilla.currencyexchange.service.interfaces.CurrencyExchangeRecordService;

@Service
@AllArgsConstructor
@Slf4j
public class RepositoryCurrencyExchangeRecordService implements CurrencyExchangeRecordService {

    private final CurrencyExchangeRecordRepository repository;
    private final CurrencyExchangeRecordMapper mapper;

    @Override
    @Transactional
    public CurrencyExchangeRecordSnapshot addRecord(CurrencyExchangeRecordAddCommand command) {
        log.info("Adding new record");
        return mapper.mapToSnapshot(repository.save(mapper.mapToRecord(command)));
    }

    @Override
    public CurrencyExchangeRecordSnapshot getById(Long id) {
        log.info("Getting record by Id");
        return repository.findById(id).map(mapper::mapToSnapshot).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Page<CurrencyExchangeResponse> getRecords(RecordsFilterQuery query, Pageable pageable) {
        return repository.findAll(getSpecification(query), pageable).map(mapper::mapToResponse);
    }

    private Specification<CurrencyExchangeRecord> getSpecification(RecordsFilterQuery filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nonNull(filter.getFromCurrencies()) && !filter.getFromCurrencies().isEmpty()) {
                Set<Currency> currencies = filter.getFromCurrencies();
                predicates.add(criteriaBuilder.and(root.get("baseCurrency").in(currencies)));
            }

            if (nonNull(filter.getToCurrencies()) && !filter.getToCurrencies().isEmpty()) {
                Set<Currency> currencies = filter.getToCurrencies();
                predicates.add(criteriaBuilder.and(root.get("requestedCurrency").in(currencies)));
            }

            if (nonNull(filter.getCreatedFrom())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder
                        .greaterThanOrEqualTo(root.get("exchangeTime"), filter.getCreatedFrom())));
            }
            if (nonNull(filter.getCreatedTo())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder
                        .lessThanOrEqualTo(root.get("exchangeTime"), filter.getCreatedTo())));
            }

            query.distinct(true);
            query.where(predicates.toArray(new Predicate[0]));
            return query.getRestriction();
        };
    }
}
