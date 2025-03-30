package com.example.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.order.properties.OrderProperties;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Value("${order.timeout}")
//    String orderTimeout;
//    @Value("${order.auto-confirm}")
//    String orderAutoConfirm;

    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/config")
    public String config(){
        return "order.timeout="+orderProperties.getTimeout()+"； " +
                "order.auto-confirm="+orderProperties.getAutoConfirm() +"；"+
                "order.db-url="+orderProperties.getDbUrl();
    }

//    @GetMapping("/config1")
//    public String config1(){
//        return "order.timeout="+orderTimeout+"； " +
//                "order.auto-confirm="+orderAutoConfirm +"；";
//    }

    @GetMapping("/create")
    @SentinelResource(value = "createOrder",blockHandler = "createOrderFallback")
//    @SentinelResource(value = "createOrder")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order =  orderService.createOrder(userId, productId);
        return order;
    }
    //兜底回调
    public Order createOrderFallback(Long productId, Long userId, BlockException e){
        Order order = new Order();
        order.setId(0);
        order.setTotalAmount(0);
        order.setNickName("未知用户");
        order.setAddress("异常信息："+e.getClass());
        return order;
    }
}
