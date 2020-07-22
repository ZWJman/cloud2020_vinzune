package com.vinzune.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerConsulController {
    private static final String INVOLE_URL="http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String getConsulOrder(){
        return restTemplate.getForObject(INVOLE_URL+"/payment/consul",String.class);
    }
}
