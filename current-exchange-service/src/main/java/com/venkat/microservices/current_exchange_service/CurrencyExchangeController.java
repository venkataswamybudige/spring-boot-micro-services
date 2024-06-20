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

    @GetMapping("/current-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue
            (@PathVariable String from,
             @PathVariable String to) {
        return new CurrencyExchange(1000l,"USD","INR", BigDecimal.valueOf(50), environment.getProperty("local.server.port"));
    }
}
