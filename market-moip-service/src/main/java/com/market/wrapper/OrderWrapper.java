package com.market.wrapper;

import java.io.Serializable;

public class OrderWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String numberOrder;

    private CartWrapper cart;

    private CustomerWrapper customer;

    private PaymentWrapper payment;

    public OrderWrapper() {
    }

    public OrderWrapper(Long id, String numberOrder, CartWrapper cart, CustomerWrapper customer, PaymentWrapper payment) {
        this.id = id;
        this.numberOrder = numberOrder;
        this.cart = cart;
        this.customer = customer;
        this.payment = payment;
    }

    public OrderWrapper(Builder builder) {
        this.id = builder.id;
        this.cart = builder.cart;
        this.customer = builder.customer;
        this.payment = builder.payment;
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

    public CartWrapper getCart() {
        return cart;
    }

    public void setCart(CartWrapper cart) {
        this.cart = cart;
    }

    public CustomerWrapper getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerWrapper customer) {
        this.customer = customer;
    }

    public PaymentWrapper getPayment() {
        return payment;
    }

    public void setPayment(PaymentWrapper payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderWrapper{" +
                "id=" + id +
                ", numberOrder='" + numberOrder + '\'' +
                ", cart=" + cart +
                ", customer=" + customer +
                ", payment=" + payment +
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
