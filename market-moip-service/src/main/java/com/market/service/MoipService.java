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

    @Override
    public void integrateWithMoip(OrderWrapper orderWrapper) throws Exception {
        CustomerRequest customerRequest = createCustomer(orderWrapper.getCustomerWrapper());
        Order order = createOrder(orderWrapper, customerRequest);
    }

    public CustomerRequest createCustomer(CustomerWrapper customerWrapper) throws Exception {
        return new CustomerRequest()
                .ownId(customerWrapper.getId().toString())
                .fullname(customerWrapper.getName())
                .email(customerWrapper.getEmail())
                .phone(createPhone(customerWrapper));
    }

    private PhoneRequest createPhone(CustomerWrapper customerWrapper) throws Exception {
        return new PhoneRequest()
                .setAreaCode("67")
                .setNumber(customerWrapper.getPhone());
    }

    public ShippingAddressRequest createAddress(CustomerWrapper customerWrapper) throws Exception {
        return new ShippingAddressRequest().street(customerWrapper.getAddress());
    }

    public Order createOrder(OrderWrapper orderWrapper, CustomerRequest customerRequest) throws Exception {
        OrderRequest orderRequest = new OrderRequest()
                .ownId(orderWrapper.getId().toString())
                .addItem("Descrição do pedido", 1, "Mais info...", 10000)
                .customer(customerRequest);

        return moip.order().create(orderRequest);
    }

    public Payment createPayment(PaymentWrapper paymentWrapper, Order order, CustomerWrapper customerWrapper) throws Exception {
        PaymentRequest paymentRequest = new PaymentRequest()
                .orderId(order.getId())
                .fundingInstrument(createFundingInstrument(paymentWrapper, customerWrapper));

        return null;
    }

    public FundingInstrumentRequest createFundingInstrument(PaymentWrapper paymentWrapper, CustomerWrapper customerWrapper) throws Exception {
        return new FundingInstrumentRequest().creditCard(createCreditCard(paymentWrapper, customerWrapper));
    }

    public CreditCardRequest createCreditCard(PaymentWrapper paymentWrapper, CustomerWrapper customerWrapper) throws Exception {
        return new CreditCardRequest()
                .hash(paymentWrapper.getHash())
                .holder(new HolderRequest()
                            .birthdate("1988-10-10")
                            .fullname(paymentWrapper.getName())
                            .phone(createPhone(customerWrapper))
                            .taxDocument(TaxDocumentRequest.cpf("333.333.333-33"))
                );
    }

}
