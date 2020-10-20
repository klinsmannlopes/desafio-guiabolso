package com.guiabolso.MockTransaction.helpers.mocks;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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

    public static String randomDate(String year, String month, int count) {

        int correctMonth = Integer.parseInt(month) -1;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(year));
        c.set(Calendar.MONTH, correctMonth);
        c.set(Calendar.DAY_OF_MONTH, count);

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(c.getTime()).toString();

    }


}
