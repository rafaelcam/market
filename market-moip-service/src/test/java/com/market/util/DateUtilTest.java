package com.market.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateUtilTest {

    @Autowired
    DateUtil dateUtil;

    @Test
    public void shouldFormatDateForMoip() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 1993);
        date.set(Calendar.MONTH, Calendar.MARCH);
        date.set(Calendar.DAY_OF_MONTH, 30);

        String dateFormated = dateUtil.formatDateForMoip(date.getTime());
        assertEquals("1993-03-30", dateFormated);
    }
}
