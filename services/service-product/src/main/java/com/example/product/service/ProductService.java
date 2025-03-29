package com.example.product.service;


import com.example.product.Product;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:58
 * @description
 **/
public interface ProductService {
    /**
     * 根据id获取商品信息
     * @param id
     * @return
     */
    Product getProductById(Integer id);
}
