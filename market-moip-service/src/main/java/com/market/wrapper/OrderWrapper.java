package com.market.wrapper;

import java.io.Serializable;

public class OrderWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String numberOrder;

    private CartWrapper cartWrapper;

    private CustomerWrapper customerWrapper;

    private PaymentWrapper paymentWrapper;

    public OrderWrapper() {
    }

    public OrderWrapper(String numberOrder, CartWrapper cartWrapper, CustomerWrapper customerWrapper, PaymentWrapper paymentWrapper) {
        this.numberOrder = numberOrder;
        this.cartWrapper = cartWrapper;
        this.customerWrapper = customerWrapper;
        this.paymentWrapper = paymentWrapper;
    }

    public OrderWrapper(Builder builder) {
        this.id = builder.id;
        this.cartWrapper = builder.cart;
        this.customerWrapper = builder.customer;
        this.paymentWrapper = builder.payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(String numberOrder) {
        this.numberOrder = numberOrder;
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
                ", numberOrder='" + numberOrder + '\'' +
                ", cartWrapper=" + cartWrapper +
                ", customerWrapper=" + customerWrapper +
                ", paymentWrapper=" + paymentWrapper +
                '}';
    }

    public static class Builder {
        private Long id;
        private String number;
        private CartWrapper cart;
        private CustomerWrapper customer;
        private PaymentWrapper payment;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder cart(CartWrapper cart) {
            this.cart = cart;
            return this;
        }

        public Builder customer(CustomerWrapper customer) {
            this.customer = customer;
            return this;
        }

        public Builder payment(PaymentWrapper payment) {
            this.payment = payment;
            return this;
        }

        public OrderWrapper build() {
            return new OrderWrapper(this);
        }
    }
}
