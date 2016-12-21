package com.market.controller;

import com.market.webhook.ResponseWebHook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/webhook")
public class WebHookController {

    @RequestMapping(value = "/payment/authorized", method = RequestMethod.POST)
    public ResponseEntity<?> paymentAuthorized(@RequestBody ResponseWebHook responseWebHook) {
        try {
            System.out.println(responseWebHook.toString());
            System.out.println("O pagamento foi autorizado com sucesso!!!");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
