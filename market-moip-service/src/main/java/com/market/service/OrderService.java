package com.market.service;

import br.com.moip.request.CustomerRequest;
import br.com.moip.resource.Order;
import com.market.request.AmountRequest;
import com.market.request.OrderRequest;
import com.market.request.SubTotalsRequest;
import com.market.util.PriceUtil;
import com.market.util.RandomUtil;
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
    ISubTotalsService subTotalsService;

    @Autowired
    PriceUtil priceUtil;

    @Autowired
    RandomUtil randomUtil;

    @Override
    public Order createOrder(OrderWrapper orderWrapper) throws Exception {
        OrderRequest orderRequest = makeOrderRequest(orderWrapper);
        return moipService.createOrder(orderRequest);
    }

    private OrderRequest makeOrderRequest(OrderWrapper orderWrapper) throws Exception {
        CustomerRequest customerRequest = customerService.makeCustomerRequest(orderWrapper.getCustomer());
        SubTotalsRequest subTotalsRequest = subTotalsService.makeSubTotalsRequest(orderWrapper.getCart());

        OrderRequest orderRequest = (OrderRequest) new OrderRequest()
                .amount(new AmountRequest().subtotals(subTotalsRequest))
                .ownId(randomUtil.generateOwnId())
                .customer(customerRequest);
        addItemOrderRequest(orderWrapper.getCart(), orderRequest);

        return orderRequest;
    }

    private void addItemOrderRequest(CartWrapper cartWrapper, OrderRequest orderRequest) {
        cartWrapper.getItems().stream().forEach(item -> {
            Integer price = priceUtil.formatNumberForMoip(item.getProduct().getPrice());
            orderRequest.addItem(item.getProduct().getName(), item.getQuantity(), item.getProduct().getDescription(), price);
        });
    }

    public void setMoipService(IMoipService moipService) {
        this.moipService = moipService;
    }
}
