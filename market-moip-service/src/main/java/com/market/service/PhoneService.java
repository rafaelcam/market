package com.market.service;

import br.com.moip.request.PhoneRequest;
import com.market.wrapper.CustomerWrapper;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements IPhoneService {

    @Override
    public PhoneRequest makePhoneRequest(CustomerWrapper customerWrapper) throws Exception {
        return new PhoneRequest()
                .setAreaCode("67")
                .setNumber(customerWrapper.getPhone());
    }
}
