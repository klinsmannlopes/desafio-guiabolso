package com.guiabolso.MockTransaction.helpers.mocks;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

@Service
public class MockHelpers {

    private static final String STRINGS = "ABCDEFGHIJKLMNOPQRSTUVWYZ";

    public static String randomAlhaNumeric(int count, Random random) {

        StringBuilder builder = new StringBuilder();
        while(count-- != 0 ) {
            int character = random.nextInt(25);
            builder.append(STRINGS.charAt(character));
        }

        return builder.toString();

    }

    public static Long randomDateLong(int random,String year,String month, int count) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(year));
        c.set(Calendar.MONTH, getMonthCorrectEnum(random, Integer.parseInt(month)));
        c.set(Calendar.DAY_OF_MONTH, count);

        Timestamp dateTimestamp = new Timestamp(c.getTimeInMillis());

        return dateTimestamp.getTime();
    }

    //Pegando numero correto para setar o mês corretamente
    private static int getMonthCorrectEnum(int random, int month) {

        int correctMonth = random -1;

        if (month > random) {
            correctMonth  = correctMonth + 1;
        }
        return correctMonth;
    }


}
