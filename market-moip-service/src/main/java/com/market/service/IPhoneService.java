package com.market.service;

import br.com.moip.request.PhoneRequest;
import com.market.wrapper.CustomerWrapper;

public interface IPhoneService {

    PhoneRequest makePhoneRequest(CustomerWrapper customerWrapper) throws Exception;
}