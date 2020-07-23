package com.vinzune.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 创建一个负载均衡的接口
 */
public interface LoadBlancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
