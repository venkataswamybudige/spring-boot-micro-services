package com.venkat.microservices.currency_conversion_service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "current-exchange-service",url = "localhost:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/current-exchange/from/{from}/to/{to}")
    public CurrencyConversion retriveExchangeValue
            (@PathVariable String from,
             @PathVariable String to);
    }
