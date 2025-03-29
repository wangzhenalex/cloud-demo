package com.example.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:27
 * @description 订单入口
 **/
@SpringBootApplication()
@EnableDiscoveryClient
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }
}
