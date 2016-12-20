package com.market;

import com.market.service.IMoipService;
import com.market.wrapper.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketMoipServiceApplicationTests {

	@Autowired
	IMoipService moipService;

	@Test
	public void createOrderTest() {
		List<ItemCartWrapper> items = new ArrayList<>();
		items.add(new ItemCartWrapper(1, new BigDecimal(3000.0), null,
				new ProductWrapper("Perfume", "Perfume de madeira", new BigDecimal(3000.0), "/img")));

		CartWrapper cart = new CartWrapper(new BigDecimal(0.0), new BigDecimal(3000.0), items);
		cart.setId(580l);
		items.get(0).setCartWrapper(cart);
		CustomerWrapper customer = new CustomerWrapper();
		customer.setId(580l);
		PaymentWrapper paymentWrapper = new PaymentWrapper("DIEGO ORNELAS RAMPIM", "4984233050012052", "09", "20", "372", 5);
		paymentWrapper.setHash("Od/96vVOlv26V1nsdI1pW+P3KAPrdWtz6OfyEdpcBJsNR6z5xXNrIeyfsz+ZwQn2e1PZW+ZelqDjbrfUGNaHT+IR2o9auDNvxg5UA+Z2pF6pBRP9KRyRzgtr3w/kJ9YJZeHGz+BO7F3+ntUZnxGJ7xabOZseCs7OjchsqcMp4IitCr5CFYJUPVmYQhj6iIOvYb5GeURBxyj4hIGEIehunJlY6NDYkWSY0NyRIqLKDL0oSTMO6dZ4jKowWHc9cPgZ75qvmNNTpmcIg9FN8mERppoSXfkwS0g2qmn2dp2YoL5gWxEHoSzhhiSZOzFG+ZPaeD8KYwTTZJwpEj4c4CvfEg==");

		try {
			OrderWrapper order = new OrderWrapper(null, cart, customer, paymentWrapper);
			order.setId(580l);
			//moipService.integrateWithMoip(order);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause());
		}

	}

}
