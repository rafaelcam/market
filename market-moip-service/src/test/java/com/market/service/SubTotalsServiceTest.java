package com.market.service;

import com.market.request.SubTotalsRequest;
import com.market.wrapper.CartWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubTotalsServiceTest {

    @Autowired
    ISubTotalsService subTotalsService;

    @Test
    public void shouldMakeSubTotalsRequest() {
        CartWrapper cart = buildCart();

        try {
            SubTotalsRequest subTotalsRequest = subTotalsService.makeSubTotalsRequest(cart);
            assertNotNull(subTotalsRequest.getDiscount());
            assertNotNull(subTotalsRequest.getAddition());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CartWrapper buildCart() {
        return new CartWrapper.Builder()
                .totalCart(BigDecimal.TEN)
                .discount(new BigDecimal(15.045))
                .addition(new BigDecimal(7.5225))
                .item(3, BigDecimal.valueOf(300.90), "Camisa", "Camisa manga Longa", BigDecimal.valueOf(100.30))
                .build();

    }
}
