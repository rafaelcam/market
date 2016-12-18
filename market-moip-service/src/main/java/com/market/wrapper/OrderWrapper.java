package com.market.wrapper;

import java.io.Serializable;

public class OrderWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String number;

    private CartWrapper cartWrapper;

    private CustomerWrapper customerWrapper;

    private PaymentWrapper paymentWrapper;

    public OrderWrapper() {
    }

    public OrderWrapper(String number, CartWrapper cartWrapper, CustomerWrapper customerWrapper, PaymentWrapper paymentWrapper) {
        this.number = number;
        this.cartWrapper = cartWrapper;
        this.customerWrapper = customerWrapper;
        this.paymentWrapper = paymentWrapper;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CartWrapper getCartWrapper() {
        return cartWrapper;
    }

    public void setCartWrapper(CartWrapper cartWrapper) {
        this.cartWrapper = cartWrapper;
    }

    public CustomerWrapper getCustomerWrapper() {
        return customerWrapper;
    }

    public void setCustomerWrapper(CustomerWrapper customerWrapper) {
        this.customerWrapper = customerWrapper;
    }

    public PaymentWrapper getPaymentWrapper() {
        return paymentWrapper;
    }

    public void setPaymentWrapper(PaymentWrapper paymentWrapper) {
        this.paymentWrapper = paymentWrapper;
    }

    @Override
    public String toString() {
        return "OrderWrapper{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", cartWrapper=" + cartWrapper +
                ", customerWrapper=" + customerWrapper +
                ", paymentWrapper=" + paymentWrapper +
                '}';
    }
}
