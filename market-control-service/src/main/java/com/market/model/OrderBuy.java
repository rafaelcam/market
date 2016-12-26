package com.market.model;

import com.market.domain.StatusOrder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "order_buy")
@NamedQueries(
        @NamedQuery(name = "OrderBuy.findByPaymentNumber",
                query = "Select o From OrderBuy o Where o.payment.numberPayment = ?1")
)
public class OrderBuy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberOrder;

    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;

    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull(message = "error.orderbuy.cart.notnull")
    private Cart cart;

    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull(message = "error.orderbuy.customer.notnull")
    private Customer customer;

    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull(message = "error.orderbuy.payment.notnull")
    private Payment payment;

    public OrderBuy() {
    }

    public OrderBuy(String numberOrder, StatusOrder statusOrder, Cart cart, Customer customer, Payment payment) {
        this.numberOrder = numberOrder;
        this.statusOrder = statusOrder;
        this.cart = cart;
        this.customer = customer;
        this.payment = payment;
    }

    public OrderBuy(Builder builder) {
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

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderBuy{" +
                "id=" + id +
                ", numberOrder='" + numberOrder + '\'' +
                ", statusOrder=" + statusOrder +
                ", cart=" + cart +
                ", customer=" + customer +
                ", payment=" + payment +
                '}';
    }

    public static class Builder {
        private Long id;
        private String number;
        private Cart cart;
        private Customer customer;
        private Payment payment;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder cart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public OrderBuy build() {
            return new OrderBuy(this);
        }
    }
}
