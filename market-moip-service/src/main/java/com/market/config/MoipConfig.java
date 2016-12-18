package com.market.config;

import br.com.moip.API;
import br.com.moip.Client;
import br.com.moip.authentication.Authentication;
import br.com.moip.authentication.BasicAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoipConfig {

    @Value("${moip.endpoint}")
    private String endpoint;

    @Value("${moip.token}")
    private String token;

    @Value("${moip.key}")
    private String key;

    @Bean
    public API factoryAPIMoip() {
        return new API(getClient());
    }

    private Client getClient() {
        return new Client(endpoint, getAuthentication());
    }

    private Authentication getAuthentication() {
        return new BasicAuth(token, key);
    }

}
