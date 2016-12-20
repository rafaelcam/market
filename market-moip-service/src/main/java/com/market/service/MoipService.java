package com.market.service;

import br.com.moip.API;
import br.com.moip.request.OrderRequest;
import br.com.moip.request.PaymentRequest;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoipService implements IMoipService {

    @Autowired
    API moip;

    @Override
    public Order createOrder(OrderRequest orderRequest) throws Exception {
        return moip.order().create(orderRequest);
    }

    @Override
    public Payment createPayment(PaymentRequest paymentRequest) throws Exception {
        return moip.payment().create(paymentRequest);
    }
}
