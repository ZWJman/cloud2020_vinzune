package com.vinzune.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----paymentInfo_ok-------出错";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-----paymentInfo_timeout-------出错";
    }
}
