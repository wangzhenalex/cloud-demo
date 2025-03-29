package com.example.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:46
 * @description
 **/
@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    void test1() {
        try {
            nacosServiceDiscovery.getServices().stream().forEach(serviceId -> {
                try {
                    nacosServiceDiscovery.getInstances(serviceId).stream().forEach(instance -> {
                        System.out.println("instance=" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
                    });
                } catch (NacosException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test() {
        for (String service : discoveryClient.getServices()) {
//            System.out.println("service=" + service);
            //获取ip+端口
            discoveryClient.getInstances(service).forEach(instance -> {
                System.out.println("instance=" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            });
        }
    }
}