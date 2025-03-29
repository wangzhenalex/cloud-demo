package com.example.order.controller;

import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order =  orderService.createOrder(userId, productId);
        return order;
    }
}
