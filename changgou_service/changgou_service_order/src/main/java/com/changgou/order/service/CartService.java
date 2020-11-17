package com.changgou.order.service;


import com.changgou.order.pojo.OrderItem;

import java.util.List;


public interface CartService {

    /**
     * 添加购物车
     * @param skuId
     * @param num
     */
    void add(Long skuId, Integer num, String username);


    /**
     * 获得购物车的数据
     * @param username
     * @return
     */
    List<OrderItem> list(String username);


    /**
     * 删除购物车商品
     * @param skuId
     */
    void delete(Long skuId, String username);
}
