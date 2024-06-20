package com.venkat.microservices.current_exchange_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository exchangeRepository;

    @GetMapping("/current-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue
            (@PathVariable String from,
             @PathVariable String to) {
        CurrencyExchange currentExchange = exchangeRepository.findByFromAndTo(from, to);
        if(currentExchange == null) {
            throw new RuntimeException("Unable to find currency exchange for " + from + " to " + to);
        }
        return new CurrencyExchange(currentExchange.getId(),currentExchange.getFrom(),currentExchange.getTo(), currentExchange.getConversionMultiple(), environment.getProperty("local.server.port"));
    }
}
