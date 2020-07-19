package com.microservice.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency/converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverterBean convertCurrency(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

         ResponseEntity<CurrencyConverterBean> bean = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConverterBean.class,uriVariables);
         CurrencyConverterBean response = bean.getBody();
        logger.info("{}",response);
        return new CurrencyConverterBean(response.getId(),from,to,response.getConversionMultiple(),quantity,response.getPort(),
                quantity.multiply(response.getConversionMultiple()));
    }

    @GetMapping("/currency/converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverterBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity){

        CurrencyConverterBean response = proxy.retriveExchangeValue(from,to);
        logger.info("{}",response);
        return new CurrencyConverterBean(response.getId(),from,to,response.getConversionMultiple(),quantity,response.getPort(),
                quantity.multiply(response.getConversionMultiple()));
    }
}
