package com.example.order.feign.fallback;

import com.example.order.feign.ProductFeignClient;
import com.example.product.Product;
import org.springframework.stereotype.Component;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/30 14:29
 * @description
 **/
@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(0);
        product.setName("兜底回调商铺");
        product.setPrice(0);
        product.setNum(0);
        return product;
    }
}
