package com.vinzune.springcloud.controller;


import com.vinzune.springcloud.entities.CommonResult;
import com.vinzune.springcloud.entities.Payment;
import com.vinzune.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result=paymentService.create(payment);
        log.info("***插入结果***"+result);
        if(result>0){
            return new CommonResult(200,"插入数据成功，serverPort"+serverPort,result);
        }
        else{
            return new CommonResult(444,"插入数据失败，serverPort"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment=paymentService.getById(id);
        if(payment!=null){
            log.info("***查询结果***"+payment.toString());
            return new CommonResult(200,"根据Id查询成功，serverPort"+serverPort,payment);
        }
        else{
            log.info("*****查询失败*****");
            return new CommonResult(444,"根据id查询失败，serverPort"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object dicovery(){
        List<String> services = discoveryClient.getServices();
        for (String s:services){
            log.info("*********获取到service********"+s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance server:instances ){
            log.info("*******获取到server****"+server.getServiceId()+"\t"+server.getHost()+"\t"+server.getPort()+"\t"+server.getUri());
        }
        return discoveryClient;
    }
}
