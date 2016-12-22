package com.market.service;


import com.market.domain.StatusOrder;
import com.market.integration.MoipIntegration;
import com.market.model.OrderBuy;
import com.market.repository.OrderBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderBuyService implements IOrderBuyService {

    @Autowired
    IItemCartService itemCartService;

    @Autowired
    OrderBuyRepository repository;

    @Autowired
    MoipIntegration moipIntegration;

    @Override
    @Transactional
    public OrderBuy create(OrderBuy orderBuy) throws Exception {
        orderBuy = moipIntegration.integrate(orderBuy);
        save(orderBuy);

        return orderBuy;
    }

    @Override
    public OrderBuy findById(Long id) throws Exception {
        return repository.findOne(id);
    }

    @Override
    public void updateStatusOrderForPaidOut(String numberPayment) throws Exception {
        OrderBuy orderBuy = repository.findByPaymentNumber(numberPayment);
        orderBuy.setStatusOrder(StatusOrder.PAGO);
        repository.save(orderBuy);
    }

    private void save(OrderBuy orderBuy) throws Exception {
        orderBuy.setStatusOrder(StatusOrder.EM_PROCESSAMENTO);
        itemCartService.loadCartInItemsCart(orderBuy.getCart());
        orderBuy = repository.save(orderBuy);
    }
}
