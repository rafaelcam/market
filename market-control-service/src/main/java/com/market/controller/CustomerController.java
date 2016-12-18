package com.market.controller;

import com.market.model.Customer;
import com.market.model.OrderBuy;
import com.market.model.Product;
import com.market.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(value = "/isvalid",method= RequestMethod.POST)
    public ResponseEntity<?> validateCustomer(@Validated @RequestBody Customer customer) {
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
