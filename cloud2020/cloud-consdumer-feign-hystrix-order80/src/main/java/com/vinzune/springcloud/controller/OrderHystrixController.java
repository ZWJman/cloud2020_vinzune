package com.vinzune.springcloud.controller;

import com.vinzune.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        String s = paymentHystrixService.paymentInfo_ok(id);
        log.info(s);
        return s;
    }
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id")Integer id){
        String s = paymentHystrixService.paymentInfo_timeout(id);
        log.info(s);
        return s;
    }
}
