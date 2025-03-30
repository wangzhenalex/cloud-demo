package com.example.order.service.impl;

import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.example.order.Order;
import com.example.order.feign.ProductFeignClient;
import com.example.order.service.OrderService;
import com.example.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:58
 * @description
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProductFeignClient productFeignClient;

    @Override
    public Order createOrder(Long userId, Long productId) {
        Order order = new Order();
//        Product productFromRemote = getProductFromRemoteAnnotation(productId);
        Product productFromRemote =  productFeignClient.getProductById(productId);
        order.setId(1);
        order.setNickName("张三");
        order.setAddress("地址");
        order.setTotalAmount(productFromRemote.getPrice());
        order.setProductList(Lists.newArrayList(productFromRemote));
        return order;
    }

    // 进阶2：完成负载均衡发送请求
    private Product getProductFromRemoteWithLoadBalance(Long productId) {
        //1、获取到商品服务所在的所有机器IP+port
        ServiceInstance choose = loadBalancerClient.choose("product-service");
        //远程URL
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/product/getProductById?id=" + productId;
        log.info("远程请求：{}", url);
        //2、给远程发送请求
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    private Product getProductFromRemoteAnnotation(Long productId) {
        String url = "http://product-service/product/getProductById?id=" + productId;
        log.info("url:" + url);
        Product forObject = restTemplate.getForObject(url, Product.class);
        return forObject;

    }

    private Product getProductFromRemote(Long productId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        ServiceInstance instance = instances.get(0);
        if (instance != null) {
            String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/getProductById?id=" + productId;
            log.info("url:" + url);
            Product forObject = restTemplate.getForObject(url, Product.class);
            return forObject;
        }
        return null;
    }
}
