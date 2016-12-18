package com.market.controller;

import com.market.model.OrderBuy;
import com.market.service.OrderBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/orderbuy")
public class OrderBuyController {

    @Autowired
    OrderBuyService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<?> makeOrderBuy(@RequestBody OrderBuy orderBuy) {
        try {
            OrderBuy orderBuyCreated = service.save(orderBuy);
            return ResponseEntity.ok(orderBuyCreated);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
