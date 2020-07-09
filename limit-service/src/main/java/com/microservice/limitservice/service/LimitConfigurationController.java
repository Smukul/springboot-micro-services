package com.microservice.limitservice.service;

import com.microservice.limitservice.Configuration;
import com.microservice.limitservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration getLimits(){
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }
}
