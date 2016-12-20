package com.market.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Component
public class PriceUtil {

    public Integer getNumberFormatedForMoip(BigDecimal price) {
        price = price.setScale(2, BigDecimal.ROUND_UP);
        String priceFormated = getDecimalFormat(2, 2).format(price).replace(".", "");

        return Integer.parseInt(priceFormated);
    }

    private DecimalFormat getDecimalFormat(Integer max, Integer min) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
        df.setMaximumFractionDigits(max);
        df.setMinimumFractionDigits(min);
        df.setGroupingUsed(false);

        return df;
    }
}
