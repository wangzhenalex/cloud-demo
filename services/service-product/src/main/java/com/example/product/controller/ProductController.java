package com.example.product.controller;

import com.example.product.Product;
import com.example.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:57
 * @description
 **/
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/product/getProductById")
    public Product getProductById(@RequestParam("id") Integer id,
                                  HttpServletRequest request) throws InterruptedException {
        Thread.sleep(10000000);
        String header = request.getHeader("Y-Token");
        System.out.println("Y-Token:" + header);
        return productService.getProductById(id);
    }
}
