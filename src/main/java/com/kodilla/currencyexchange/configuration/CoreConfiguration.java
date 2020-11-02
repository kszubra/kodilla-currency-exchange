package com.kodilla.currencyexchange.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories(basePackages = "com.kodilla.currencyexchange.domain.repository")
@EntityScan(basePackages = {"com.kodilla.currencyexchange.domain.model"})
@ComponentScan(basePackages = {"com.kodilla.currencyexchange.service.*"})
public class CoreConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
