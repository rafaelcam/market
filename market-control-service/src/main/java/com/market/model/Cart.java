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

    private BigDecimal addition;

    @Column(name = "total_cart")
    private BigDecimal totalCart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<ItemCart> items;

    public Cart() {
    }

    public Cart(BigDecimal discount, BigDecimal addition, BigDecimal totalCart, List<ItemCart> items) {
        this.discount = discount;
        this.addition = addition;
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

    public BigDecimal getAddition() {
        return addition;
    }

    public void setAddition(BigDecimal addition) {
        this.addition = addition;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", discount=" + discount +
                ", addition=" + addition +
                ", totalCart=" + totalCart +
                ", items=" + items +
                '}';
    }
}
