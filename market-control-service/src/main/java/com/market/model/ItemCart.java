package com.market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author JRafael
 */
@Entity
@Table(name = "item_cart")
public class ItemCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @Column(name = "total_item")
    private BigDecimal totalItem;

    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Cart cart;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product product;

    public ItemCart() {
    }

    public ItemCart(int quantity, BigDecimal totalItem, Cart cart, Product product) {
        this.quantity = quantity;
        this.totalItem = totalItem;
        this.cart = cart;
        this.product = product;
    }

    public ItemCart(int quantity, BigDecimal totalItem, Product product) {
        this.quantity = quantity;
        this.totalItem = totalItem;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(BigDecimal totalItem) {
        this.totalItem = totalItem;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ItemCart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", totalItem=" + totalItem +
                ", product=" + product +
                '}';
    }
}
