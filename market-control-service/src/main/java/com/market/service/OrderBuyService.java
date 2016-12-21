package com.market.service;


import com.market.integration.MoipIntegration;
import com.market.model.OrderBuy;
import com.market.repository.OrderBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderBuyService implements IOrderBuyService {

    @Autowired
    IItemCartService itemCartService;

    @Autowired
    OrderBuyRepository repository;

    @Autowired
    MoipIntegration moipIntegration;

    @Transactional
    public OrderBuy save(OrderBuy orderBuy) throws Exception {
        itemCartService.loadCartInItemsCart(orderBuy.getCart());
        orderBuy = repository.save(orderBuy);
        moipIntegration.integrate(orderBuy);

        return orderBuy;
    }
}
