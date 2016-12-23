package com.market.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceUtilTest {

    @Autowired
    PriceUtil priceUtil;

    @Test
    public void shouldFormatNumberForMoip() {
        Integer number = priceUtil.formatNumberForMoip(BigDecimal.valueOf(30.50));
        assertEquals(Integer.valueOf(3050), number);
    }
}
