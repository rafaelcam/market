package com.market.service;

import com.market.model.Cart;
import com.market.model.OrderBuy;
import com.market.model.Payment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubTotalsServiceTest {

    private static int INSTALLMENTS_NUMBER = 3;

    @Autowired
    SubTotalsService subTotalsService;

    @Test
    public void shouldcalculateSubTotalsTest() {
        OrderBuy order = buildOrder();

        try {
            subTotalsService.calculateSubTotals(order);
            Assert.assertEquals(BigDecimal.valueOf(7.5225), order.getCart().getAddition());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private OrderBuy buildOrder() {
        return new OrderBuy.Builder()
                .cart(buildCart())
                .payment(buildPayment())
                .build();
    }

    private Cart buildCart() {
        return new Cart.Builder()
                .totalCart(BigDecimal.valueOf(300.90))
                .item(3, BigDecimal.valueOf(300.90), "Camisa", "Camisa manga Longa", BigDecimal.valueOf(100.30))
                .build();

    }

    private Payment buildPayment() {
        return new Payment.Builder()
                .name("TEST S MOIP")
                .installments(INSTALLMENTS_NUMBER)
                .hash("Od/96vVOlv26V1nsdI1pW+P3KAPrdWtz6OfyEdpcBJsNR6z5xXNrIeyfsz+ZwQn2e1PZW+ZelqDjbrfUG" +
                        "NaHT+IR2o9auDNvxg5UA+Z2pF6pBRP9KRyRzgtr3w/kJ9YJZeHGz+BO7F3+ntUZnxGJ7xabOZseCs7O" +
                        "jchsqcMp4IitCr5CFYJUPVmYQhj6iIOvYb5GeURBxyj4hIGEIehunJlY6NDYkWSY0NyRIqLKDL0oSTM" +
                        "O6dZ4jKowWHc9cPgZ75qvmNNTpmcIg9FN8mERppoSXfkwS0g2qmn2dp2YoL5gWxEHoSzhhiSZOzFG+Z" +
                        "PaeD8KYwTTZJwpEj4c4CvfEg==")
                .build();
    }
}
