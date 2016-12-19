package com.market.service;

import br.com.moip.API;
import br.com.moip.request.*;
import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;
import com.market.wrapper.CustomerWrapper;
import com.market.wrapper.OrderWrapper;
import com.market.wrapper.PaymentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoipService implements IMoipService {

    @Autowired
    API moip;

    public void integrateWithMoip(OrderWrapper orderWrapper) {
        CustomerRequest customerRequest = createCustomer(orderWrapper.getCustomerWrapper());
        Order order = createOrder(orderWrapper, customerRequest);
    }

    public CustomerRequest createCustomer(CustomerWrapper customerWrapper) {
        return new CustomerRequest()
                .ownId(customerWrapper.getId().toString())
                .fullname(customerWrapper.getName())
                .email(customerWrapper.getEmail())
                .phone(new PhoneRequest().setNumber(customerWrapper.getPhone()));
    }

    public ShippingAddressRequest createAddress(CustomerWrapper customerWrapper) {
        return new ShippingAddressRequest().street(customerWrapper.getAddress());
    }

    public Order createOrder(OrderWrapper orderWrapper, CustomerRequest customerRequest) {
        OrderRequest orderRequest = new OrderRequest()
                .ownId(orderWrapper.getId().toString())
                .addItem("Descrição do pedido", 1, "Mais info...", 10000)
                .customer(customerRequest);

        return moip.order().create(orderRequest);
    }

    public Payment createPayment(PaymentWrapper paymentWrapper) {

        PaymentRequest paymentRequest = new PaymentRequest().fundingInstrument(createFundingInstrument(paymentWrapper));

        return null;
    }

    public FundingInstrumentRequest createFundingInstrument(PaymentWrapper paymentWrapper) {
        return new FundingInstrumentRequest().creditCard(createCreditCard(paymentWrapper));
    }

    public CreditCardRequest createCreditCard(PaymentWrapper paymentWrapper) {
        return new CreditCardRequest();
    }

}
