package com.market.service;

import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import com.market.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService implements IIntegrationService {

    @Autowired
    IOrderService orderService;

    @Autowired
    IPaymentService paymentService;

    @Override
    public void integrateMoip(OrderWrapper orderWrapper) throws Exception {
        Order order = orderService.createOrder(orderWrapper);
        Payment payment = paymentService.createPayment(orderWrapper, order);

        orderWrapper.setNumberOrder(order.getId());
        orderWrapper.getPaymentWrapper().setNumberPayment(payment.getId());
    }
}
