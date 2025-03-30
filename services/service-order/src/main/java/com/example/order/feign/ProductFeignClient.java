package com.example.order.feign;

import com.example.product.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/30 11:34
 * @description
 **/
@FeignClient(value = "product-service")
public interface ProductFeignClient {
    /**
     * 根据id获取商品信息
     * 1、标准在controller上，接收这样的请求
     * 2、标准在FeignClient上，发送这样的请求
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/product/getProductById")
    Product getProductById(@RequestParam("id") Long id);
}
