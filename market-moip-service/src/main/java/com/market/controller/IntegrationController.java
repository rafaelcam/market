package com.market.controller;

import com.market.service.IIntegrationService;
import com.market.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/integration")
public class IntegrationController {

    @Autowired
    IIntegrationService integrationService;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<?> validateOrderBuy(@RequestBody OrderWrapper orderWrapper) {
        try {
            integrationService.integrateMoip(orderWrapper);
            return ResponseEntity.ok(orderWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/payment/authorized")
    public ResponseEntity<?> paymentAuthorized() {
        try {
            System.out.println("O pagamento foi autorizado com sucesso!!!");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
