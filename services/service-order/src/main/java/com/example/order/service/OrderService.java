package com.example.order.service;


import com.example.order.Order;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:58
 * @description
 **/
public interface OrderService {

    Order createOrder(Long userId, Long productId);
}
