package com.example.order.controller;

import com.example.order.properties.OrderProperties;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.order.Order;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:57
 * @description
 **/
@RefreshScope//自动刷新
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Value("${order.timeout}")
    String orderTimeout;
    @Value("${order.auto-confirm}")
    String orderAutoConfirm;

    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/config")
    public String config(){
        return "order.timeout="+orderProperties.getTimeout()+"； " +
                "order.auto-confirm="+orderProperties.getAutoConfirm() +"；"+
                "order.db-url="+orderProperties.getDbUrl();
    }
    @GetMapping("/config1")
    public String config1(){
        return "order.timeout="+orderTimeout+"； " +
                "order.auto-confirm="+orderAutoConfirm +"；";
    }
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order =  orderService.createOrder(userId, productId);
        return order;
    }
}
