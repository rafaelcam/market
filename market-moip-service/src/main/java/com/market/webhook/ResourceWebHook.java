package com.market.webhook;

import br.com.moip.resource.Order;
import br.com.moip.resource.Payment;

public class ResourceWebHook {

    private Payment payment;

    private Order order;

    public ResourceWebHook() {
    }

    public ResourceWebHook(Payment payment, Order order) {
        this.payment = payment;
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ResourceWebHook{" +
                "payment=" + payment +
                ", order=" + order +
                '}';
    }
}
