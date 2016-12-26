package com.market.service;

import com.market.model.Cart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCartServiceTest {

    @Autowired
    ItemCartService itemCartService;

    @Test
    public void shouldLoadCartInItemsCartTest() {
        Cart cart = buildCart();

        try {
            itemCartService.loadCartInItemsCart(cart);
            Assert.assertEquals(cart, cart.getItems().get(0).getCart());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Cart buildCart() {
        return new Cart.Builder()
                .totalCart(BigDecimal.TEN)
                .discount(new BigDecimal(15.045))
                .addition(new BigDecimal(7.5225))
                .item(3, BigDecimal.valueOf(300.90), "Camisa", "Camisa manga Longa", BigDecimal.valueOf(100.30))
                .build();

    }
}
