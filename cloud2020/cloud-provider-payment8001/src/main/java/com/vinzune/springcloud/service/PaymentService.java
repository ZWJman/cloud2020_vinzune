package com.vinzune.springcloud.service;

import com.vinzune.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getById(@Param("id") Long id);
}
