package com.market.service;

import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import com.market.wrapper.OrderWrapper;

public interface IPaymentService {

    Payment createPayment(OrderWrapper orderWrapper, Order order) throws Exception;
}