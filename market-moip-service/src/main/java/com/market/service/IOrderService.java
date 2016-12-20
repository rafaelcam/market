package com.market.service;

import br.com.moip.resource.Order;
import com.market.wrapper.OrderWrapper;

public interface IOrderService {

    public Order createOrder(OrderWrapper orderWrapper) throws Exception;
}