package com.market.service;

import com.market.model.OrderBuy;

public interface IOrderBuyService {

    OrderBuy create(OrderBuy orderBuy) throws Exception;

    OrderBuy findById(Long id) throws Exception;

    void updateStatusOrderForPaidOut(String numberPayment) throws Exception;

}
