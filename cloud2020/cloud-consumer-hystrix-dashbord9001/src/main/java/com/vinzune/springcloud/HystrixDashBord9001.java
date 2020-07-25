package com.vinzune.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringCloudApplication
@EnableHystrixDashboard
public class HystrixDashBord9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBord9001.class);
    }
}
