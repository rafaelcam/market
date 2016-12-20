package com.market.service;

import com.market.wrapper.OrderWrapper;

public interface IIntegrationService {

    void integrateMoip(OrderWrapper orderWrapper) throws Exception;
}