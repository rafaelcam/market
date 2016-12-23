package com.market.service;

import br.com.moip.resource.Order;
import com.market.request.OrderRequest;
import com.market.wrapper.CartWrapper;
import com.market.wrapper.CustomerWrapper;
import com.market.wrapper.OrderWrapper;
import com.market.wrapper.PaymentWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @MockBean
    IMoipService moipService;

    @Autowired
    IIntegrationService integrationService;

    @Before
    public void setup() {
        orderService.setMoipService(moipService);
    }

    @Test
    public void shouldCreateOrderResquestTest() {
        OrderWrapper orderWrapper = buildOrder();

        try {
            given(moipService.createOrder(new OrderRequest()))
                    .willReturn(new Order());

            orderService.createOrder(orderWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @Test
    @Ignore
    public void shouldCreateOrderTest() {
        OrderWrapper orderWrapper = new OrderWrapper.Builder()
                .cart(buildCart())
                .customer(buildCustomer())
                .payment(buildPayment())
                .build();

        try {
            integrationService.integrateMoip(orderWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OrderWrapper buildOrder() {
        return new OrderWrapper.Builder()
                .cart(buildCart())
                .customer(buildCustomer())
                .payment(buildPayment())
                .build();
    }

    private CartWrapper buildCart() {
        return new CartWrapper.Builder()
                .totalCart(BigDecimal.TEN)
                .discount(new BigDecimal(15.045))
                .addition(new BigDecimal(7.5225))
                .item(3, BigDecimal.valueOf(300.90), "Camisa", "Camisa manga Longa", BigDecimal.valueOf(100.30))
                .build();

    }

    private CustomerWrapper buildCustomer() {
        return new CustomerWrapper.Builder()
                .email("test@moip.service.com")
                .name("Test Service Moip")
                .cpf("111.111.111-11")
                .areaCode("11")
                .phone("999204587")
                .address("Street Test Moip, 348, Av. Moip")
                .dateBirth(new Date())
                .build();
    }

    private PaymentWrapper buildPayment() {
        return new PaymentWrapper.Builder()
                .name("TEST S MOIP")
                .installments(3)
                .hash("Od/96vVOlv26V1nsdI1pW+P3KAPrdWtz6OfyEdpcBJsNR6z5xXNrIeyfsz+ZwQn2e1PZW+ZelqDjbrfUG" +
                        "NaHT+IR2o9auDNvxg5UA+Z2pF6pBRP9KRyRzgtr3w/kJ9YJZeHGz+BO7F3+ntUZnxGJ7xabOZseCs7O" +
                        "jchsqcMp4IitCr5CFYJUPVmYQhj6iIOvYb5GeURBxyj4hIGEIehunJlY6NDYkWSY0NyRIqLKDL0oSTM" +
                        "O6dZ4jKowWHc9cPgZ75qvmNNTpmcIg9FN8mERppoSXfkwS0g2qmn2dp2YoL5gWxEHoSzhhiSZOzFG+Z" +
                        "PaeD8KYwTTZJwpEj4c4CvfEg==")
                .build();
    }
}
