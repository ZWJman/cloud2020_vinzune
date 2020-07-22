package com.vinzune.springcloud.dao;


import com.vinzune.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getById(@Param("id") Long id);
}
