package com.market.service;

import com.market.request.SubTotalsRequest;
import com.market.util.PriceUtil;
import com.market.wrapper.CartWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTotalsService implements ISubTotalsService {

    @Autowired
    PriceUtil priceUtil;

    @Override
    public SubTotalsRequest makeSubTotalsRequest(CartWrapper cartWrapper) throws Exception {
        Integer discount = priceUtil.formatNumberForMoip(cartWrapper.getDiscount());
        Integer addition = priceUtil.formatNumberForMoip(cartWrapper.getAddition());

        return new SubTotalsRequest().addition(addition).discount(discount);
    }
}
