package com.market.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;

@Component
public class RandomUtil {

    public String generateOwnId() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(32, random).toString(32);
    }
}
