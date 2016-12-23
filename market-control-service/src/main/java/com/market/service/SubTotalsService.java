package com.market.service;

import com.market.model.OrderBuy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SubTotalsService implements ISubTotalsService {

    @Value("${installments.addition.percentage}")
    private BigDecimal percentage;

    @Override
    public void calculateSubTotals(OrderBuy order) throws Exception {
        calculateAdditionInstallments(order);
    }

    private void calculateAdditionInstallments(OrderBuy order) {
        if(order.getPayment().getInstallments() > 1) {
            BigDecimal addition = order.getCart().getTotalCart()
                    .multiply((percentage.divide(BigDecimal.valueOf(100D))));
            order.getCart().setAddition(addition);
        } else {
            order.getCart().setAddition(BigDecimal.ZERO);
        }
    }
}
