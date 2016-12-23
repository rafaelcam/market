package com.market.service;

import br.com.moip.request.CustomerRequest;
import com.market.wrapper.CustomerWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    ICustomerService customerService;

    @Test
    public void shouldMakeCustomerRequest() {
        CustomerWrapper customer = buildCustomer();

        try {
            CustomerRequest customerRequest = customerService.makeCustomerRequest(customer);
            assertEquals(customer.getName(), customerRequest.getFullname());
            assertEquals(customer.getEmail(), customerRequest.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CustomerWrapper buildCustomer() {
        return new CustomerWrapper.Builder()
                .email("test@moip.service.com")
                .name("Test Service Moip")
                .cpf("111.111.111-11")
                .areaCode("11")
                .phone("999204587")
                .address("Street Test Moip, 348, Av. Moip")
                .dateBirth(new Date())
                .build();
    }
}
