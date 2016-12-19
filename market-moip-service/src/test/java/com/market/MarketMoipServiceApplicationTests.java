package com.market;

import com.market.service.IMoipService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketMoipServiceApplicationTests {

	@Autowired
	IMoipService moipService;

	@Test
	public void createOrderTest() {
		moipService.createOrder();

	}

}
