package com.market.controller;

import com.market.client.MarketControlClient;
import com.market.webhook.ResponseWebHook;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/webhook")
public class WebHookController {

    Logger logger = Logger.getLogger(WebHookController.class);

    @Autowired
    MarketControlClient marketControlClient;

    @RequestMapping(value = "/payment/authorized", method = RequestMethod.POST)
    public ResponseEntity<?> paymentAuthorized(@RequestBody ResponseWebHook responseWebHook) {
        try {
            logger.info("Successfully authorized payment "+responseWebHook+".");
            String paymentNumber = responseWebHook.getResource().getPayment().getId();
            marketControlClient.updateStatusOrderForPaidOut(paymentNumber);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
