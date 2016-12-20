package com.market.service;

import br.com.moip.request.CustomerRequest;
import com.market.wrapper.CustomerWrapper;

public interface ICustomerService {

    CustomerRequest makeCustomerRequest(CustomerWrapper customerWrapper) throws Exception;
}