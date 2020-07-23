package com.vinzune.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    //如果使用了自定义的负载均衡   loadBalancer 就不用这个注解    会出现 No avaliable instance  of  XXX的错误
    //    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
