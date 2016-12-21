package com.market.service;

import com.market.model.OrderBuy;

public interface IOrderBuyService {

    public OrderBuy create(OrderBuy orderBuy) throws Exception;

    public OrderBuy findById(Long id) throws Exception;

}
