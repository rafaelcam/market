package com.market.wrapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CartWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private BigDecimal discount;

    private BigDecimal totalCart;

    private List<ItemCartWrapper> items;

    public CartWrapper() {
    }

    public CartWrapper(BigDecimal discount, BigDecimal totalCart, List<ItemCartWrapper> items) {
        this.discount = discount;
        this.totalCart = totalCart;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalCart() {
        return totalCart;
    }

    public void setTotalCart(BigDecimal totalCart) {
        this.totalCart = totalCart;
    }

    public List<ItemCartWrapper> getItems() {
        return items;
    }

    public void setItems(List<ItemCartWrapper> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CartWrapper{" +
                "id=" + id +
                ", discount=" + discount +
                ", totalCart=" + totalCart +
                ", items=" + items +
                '}';
    }
}
