package com.market.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemCartWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private int quantity;

    private BigDecimal totalItem;

    @JsonIgnore
    private CartWrapper cartWrapper;

    private ProductWrapper productWrapper;

    public ItemCartWrapper() {
    }

    public ItemCartWrapper(int quantity, BigDecimal totalItem, ProductWrapper productWrapper) {
        this.quantity = quantity;
        this.totalItem = totalItem;
        this.productWrapper = productWrapper;
    }

    public ItemCartWrapper(int quantity, BigDecimal totalItem, CartWrapper cartWrapper, ProductWrapper productWrapper) {
        this.quantity = quantity;
        this.totalItem = totalItem;
        this.cartWrapper = cartWrapper;
        this.productWrapper = productWrapper;
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

    public CartWrapper getCartWrapper() {
        return cartWrapper;
    }

    public void setCartWrapper(CartWrapper cartWrapper) {
        this.cartWrapper = cartWrapper;
    }

    public ProductWrapper getProductWrapper() {
        return productWrapper;
    }

    public void setProductWrapper(ProductWrapper productWrapper) {
        this.productWrapper = productWrapper;
    }

    @Override
    public String toString() {
        return "ItemCartWrapper{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", totalItem=" + totalItem +
                ", cartWrapper=" + cartWrapper +
                ", productWrapper=" + productWrapper +
                '}';
    }
}
