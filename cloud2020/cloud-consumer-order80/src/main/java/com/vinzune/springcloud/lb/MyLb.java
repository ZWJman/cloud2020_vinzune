package com.vinzune.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现自定义的负载均衡接口实现自定义的负载均衡算法
 */
@Component
public class MyLb implements LoadBlancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            next=current>=2147483647?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("**********next:"+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);

    }
}
