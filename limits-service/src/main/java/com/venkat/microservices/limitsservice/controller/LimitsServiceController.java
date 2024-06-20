package com.venkat.microservices.limitsservice.controller;


import com.venkat.microservices.limitsservice.bean.Limits;
import com.venkat.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsServiceController {

    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public Limits retriveLimits() {
       // return new Limits(1, 1000);
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
