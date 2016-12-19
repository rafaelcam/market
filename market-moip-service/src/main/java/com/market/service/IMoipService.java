package com.market.service;

import br.com.moip.resource.Order;
import com.market.wrapper.OrderWrapper;

public interface IMoipService {

    public void integrateWithMoip(OrderWrapper orderWrapper) throws Exception;
}