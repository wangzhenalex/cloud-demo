package com.example.product.service.impl;

import com.example.product.Product;
import com.example.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:58
 * @description
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Integer id) {
        System.out.println("查询商品信息，id=" + id);
        Product product = new Product();
        product.setId(id);
        product.setName("苹果-" + id);
        product.setPrice(new Random().nextInt());
        product.setNum(new Random().nextInt());
        return product;
    }
}
