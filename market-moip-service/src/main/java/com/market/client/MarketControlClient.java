package com.market.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class MarketControlClient {

    @Value("${market.control.service.url}")
    private String url;

    @Autowired
    RestOperations restOperations;

    public void updateStatusOrderForPaidOut(String paymentNumber) throws Exception {
        restOperations.postForObject(url+"/orderbuy/statusforpaid", paymentNumber, String.class);
    }

}
