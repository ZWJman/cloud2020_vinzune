package com.vinzune.springcloud.controller;

import com.vinzune.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        String s = paymentService.paymentInfo_ok(id);
        log.info(s);
        return s;
    }
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id")Integer id){
        String s = paymentService.paymentInfo_timeout(id);
        log.info(s);
        return s;
    }
    //=====服务熔断
    @GetMapping(value = "/payment/circuit/get/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info(s);
        return s;
    }
}
