package com.market.service;

import br.com.moip.request.CustomerRequest;
import br.com.moip.request.OrderRequest;
import br.com.moip.resource.Order;
import com.market.util.PriceUtil;
import com.market.wrapper.CartWrapper;
import com.market.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IMoipService moipService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    PriceUtil priceUtil;

    @Override
    public Order createOrder(OrderWrapper orderWrapper) throws Exception {
        OrderRequest orderRequest = makeOrderRequest(orderWrapper);
        return moipService.createOrder(orderRequest);
    }

    private OrderRequest makeOrderRequest(OrderWrapper orderWrapper) throws Exception {
        CustomerRequest customerRequest = customerService.makeCustomerRequest(orderWrapper.getCustomerWrapper());

        return new OrderRequest()
                .ownId(orderWrapper.getId().toString())
                .customer(customerRequest);
    }

    private void addItemOrderRequest(CartWrapper cartWrapper, OrderRequest orderRequest) {
        cartWrapper.getItems().stream().forEach(item -> {
            Integer price = priceUtil.getNumberFormatedForMoip(item.getProductWrapper().getPrice());
            orderRequest.addItem(item.getProductWrapper().getName(), item.getQuantity(), item.getProductWrapper().getDescription(), price);
        });
    }
}
