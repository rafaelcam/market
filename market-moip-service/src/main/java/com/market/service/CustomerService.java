package com.market.service;

import br.com.moip.request.CustomerRequest;
import com.market.wrapper.CustomerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    IPhoneService phoneService;

    @Override
    public CustomerRequest makeCustomerRequest(CustomerWrapper customerWrapper) throws Exception {
        return new CustomerRequest()
                .ownId(customerWrapper.getId().toString())
                .fullname(customerWrapper.getName())
                .email(customerWrapper.getEmail())
                .phone(phoneService.makePhoneRequest(customerWrapper));
    }
}
