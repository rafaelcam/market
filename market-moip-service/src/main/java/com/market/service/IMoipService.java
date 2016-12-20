package com.market.service;

import br.com.moip.request.OrderRequest;
import br.com.moip.request.PaymentRequest;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;

public interface IMoipService {

    Order createOrder(OrderRequest orderRequest) throws Exception;

    Payment createPayment(PaymentRequest paymentRequest) throws Exception;
}