package com.example;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

/**
 * @author ankush.nakaskar
 */
public class TestJava {

    public static void main(String[] args) {
        String input ="15-AUG-24";
//        input="2005-NOV-12";
        String format="yyyy-MMM-dd";
        String format1 ="dd MMM YY";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

//        LocalDate date = LocalDate.parse(input,formatter);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(format, Locale.US);

        formatter1 =new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd-MMM-yy")
                .toFormatter(Locale.getDefault());
        // create a LocalDate object and
        LocalDate lt
                = LocalDate.parse(input, formatter1);

        // print result
        System.out.println("LocalDate : "
                + lt.toString());

//        System.out.println(date);
        fun();
    }

    private static void fun() {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date expDate = df.parse("25-aug-2019");
            System.out.println(expDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
