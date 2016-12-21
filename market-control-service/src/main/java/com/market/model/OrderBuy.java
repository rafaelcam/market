package com.market.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "order_buy")
public class OrderBuy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberOrder;

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

    public OrderBuy(String numberOrder, Cart cart, Customer customer, Payment payment) {
        this.numberOrder = numberOrder;
        this.cart = cart;
        this.customer = customer;
        this.payment = payment;
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
                ", cart=" + cart +
                ", customer=" + customer +
                ", payment=" + payment +
                '}';
    }
}
