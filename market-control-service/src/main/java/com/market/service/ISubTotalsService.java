package com.market.service;

import com.market.model.OrderBuy;

public interface ISubTotalsService {

    void calculateSubTotals(OrderBuy order) throws Exception;
}
