package com.market.service;

import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.PaymentRequest;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import com.market.wrapper.CustomerWrapper;
import com.market.wrapper.OrderWrapper;
import com.market.wrapper.PaymentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    IMoipService moipService;

    @Autowired
    IFundingInstrumentService fundingInstrumentService;

    @Override
    public Payment createPayment(OrderWrapper orderWrapper, Order order) throws Exception {
        PaymentRequest paymentRequest = makePaymentRequest(
                orderWrapper.getPayment(), order, orderWrapper.getCustomer());

        return moipService.createPayment(paymentRequest);
    }

    private PaymentRequest makePaymentRequest(PaymentWrapper paymentWrapper, Order order, CustomerWrapper customerWrapper) throws Exception {
        FundingInstrumentRequest fundingInstrumentRequest
                = fundingInstrumentService.makeFundingInstrument(paymentWrapper, customerWrapper);

        return new PaymentRequest()
                .installmentCount(paymentWrapper.getInstallments())
                .orderId(order.getId())
                .fundingInstrument(fundingInstrumentRequest);
    }
}
