package com.market.service;

import com.market.request.SubTotalsRequest;
import com.market.wrapper.CartWrapper;

public interface ISubTotalsService {

    public SubTotalsRequest makeSubTotalsRequest(CartWrapper cartWrapper) throws Exception;

}
