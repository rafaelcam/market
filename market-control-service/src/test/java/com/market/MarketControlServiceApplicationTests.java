package com.market;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketControlServiceApplicationTests {

	@Value("${installments.addition.percentage}")
	private BigDecimal percentage;


	@Test
	public void contextLoads() {
		System.out.println(percentage);
	}

}
