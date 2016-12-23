package com.market.wrapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private BigDecimal discount;

    private BigDecimal addition;

    private BigDecimal totalCart;

    private List<ItemCartWrapper> items;

    public CartWrapper() {
    }

    public CartWrapper(Long id, BigDecimal discount, BigDecimal addition, BigDecimal totalCart, List<ItemCartWrapper> items) {
        this.id = id;
        this.discount = discount;
        this.addition = addition;
        this.totalCart = totalCart;
        this.items = items;
    }

    public CartWrapper(Builder builder) {
        this.id = builder.id;
        this.discount = builder.discount;
        this.addition = builder.addition;
        this.totalCart = builder.totalCart;
        this.items = builder.items;
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
                ", addition=" + addition +
                ", totalCart=" + totalCart +
                ", items=" + items +
                '}';
    }

    public static class Builder {
        private Long id;
        private BigDecimal discount;
        private BigDecimal addition;
        private BigDecimal totalCart;
        private List<ItemCartWrapper> items;

        public Builder() {
            items = new ArrayList<>();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder discount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }

        public Builder addition(BigDecimal addition) {
            this.addition = addition;
            return this;
        }

        public Builder totalCart(BigDecimal totalCart) {
            this.totalCart = totalCart;
            return this;
        }

        public Builder item(int quantity, BigDecimal totalItem,
                            String nameProduct, String descriptionProduct, BigDecimal priceProduct) {
            ItemCartWrapper item = new ItemCartWrapper(quantity, totalItem,
                    new ProductWrapper(nameProduct, descriptionProduct, priceProduct));

            this.items.add(item);
            return this;
        }

        public CartWrapper build() {
            return new CartWrapper(this);
        }
    }
}
