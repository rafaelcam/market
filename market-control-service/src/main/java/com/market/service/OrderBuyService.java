package com.market.service;


import com.market.model.OrderBuy;
import com.market.repository.OrderBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBuyService implements IOrderBuyService {

    @Autowired
    OrderBuyRepository repository;

    public OrderBuy save(OrderBuy orderBuy) throws Exception {
        return repository.save(orderBuy);
    }
}
