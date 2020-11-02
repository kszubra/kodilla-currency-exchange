package com.kodilla.currencyexchange.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.kodilla.currencyexchange.domain.repository")
@EntityScan(basePackages = {"com.kodilla.currencyexchange.domain.model"})
@ComponentScan(basePackages = {"com.kodilla.currencyexchange.service.*"})
public class CoreConfiguration {
}
