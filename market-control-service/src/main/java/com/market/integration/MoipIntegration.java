package com.market.integration;

import com.market.model.OrderBuy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class MoipIntegration {

    @Value("${market.moip.service.url}")
    private String url;

    @Autowired
    RestOperations restOperations;

    public OrderBuy integrate(OrderBuy orderBuy) throws Exception {
        return restOperations.postForObject(url+"/integration", orderBuy, OrderBuy.class);
    }

}
