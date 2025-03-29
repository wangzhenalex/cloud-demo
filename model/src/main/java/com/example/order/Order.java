package com.example.order;

import lombok.Data;

import java.util.List;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/29 16:59
 * @description
 **/
@Data
public class Order {

    private Integer id;

    private String nickName;

    private String address;

    private Integer totalAmount;

    private List<Object> productList;
}
