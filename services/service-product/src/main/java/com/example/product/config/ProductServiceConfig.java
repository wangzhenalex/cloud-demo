package com.example.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 17:28
 * @description
 **/
@Configuration
public class ProductServiceConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
