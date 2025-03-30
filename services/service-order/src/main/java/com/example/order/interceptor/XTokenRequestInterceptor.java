package com.example.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/30 13:13
 * @description
 **/
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("XTokenRequestInterceptor ....");
        requestTemplate.header("Y-Token", UUID.randomUUID().toString());
    }
}
