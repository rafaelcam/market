package com.market.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discount;

    @Column(name = "total_cart")
    private BigDecimal totalCart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<ItemCart> items;

    public Cart() {
    }

    public Cart(BigDecimal discount, BigDecimal totalCart, List<ItemCart> items) {
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

    public List<ItemCart> getItems() {
        return items;
    }

    public void setItems(List<ItemCart> items) {
        this.items = items;
    }
}
