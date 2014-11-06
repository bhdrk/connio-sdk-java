package com.connio.sdk.api.systemservices;


import com.connio.sdk.api.utils.Asserts;
import com.connio.sdk.http.utils.ClassResourceLoader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * TODO: javadoc
 *
 * @author bdirik
 * @since 23.09.2014
 */
public class TestUtils {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("-yy-MM-dd-HH-mm-ss-SSS");

    private static final int MAX_LENGTH = 64;

    public static String randomName(String prefix) {
        String suffix = FORMATTER.format(new Date());
        int maxLength = MAX_LENGTH - suffix.length();
        Asserts.maxSize(prefix, maxLength, "Prefix");
        return prefix + suffix;
    }

    public static String generateIMEI() {
        int pos;
        int[] array = new int[15];
        int sum = 0;
        int final_digit = 0;
        int t = 0;
        int len_offset = 0;
        int len = 15;

        //
        // Fill in the first two values of the string based with the specified prefix.
        // Reporting Body Identifier list: http://en.wikipedia.org/wiki/Reporting_Body_Identifier
        //

        Random random = new Random();
        String[] rbi = new String[]{"01", "10", "30", "33", "35", "44", "45", "49", "50", "51", "52", "53", "54", "86", "91", "98", "99"};
        String str = rbi[random.nextInt(rbi.length)];
        array[0] = new Integer("" + str.charAt(0));
        array[1] = new Integer("" + str.charAt(1));
        pos = 2;

        //
        // Fill all the remaining numbers except for the last one with random values.
        //

        while (pos < len - 1) {
            array[pos++] = random.nextInt(10);
        }

        //
        // Calculate the Luhn checksum of the values thus far.
        //

        len_offset = (len + 1) % 2;
        for (pos = 0; pos < len - 1; pos++) {
            if (((pos + len_offset) % 2) > 0) {
                t = array[pos] * 2;
                if (t > 9) {
                    t -= 9;
                }
                sum += t;
            } else {
                sum += array[pos];
            }
        }

        //
        // Choose the last digit so that it causes the entire string to pass the checksum.
        //

        final_digit = (10 - (sum % 10)) % 10;
        array[len - 1] = final_digit;

        // Output the IMEI value.
        String output = "";
        for (int s : array) {
            output += s;
        }

        return output.substring(0, len);
    }

    public static String resource(String name) {
        String resource = ClassResourceLoader.getResourceAsString(name, TestUtils.class);
        if (resource == null) {
            throw new RuntimeException("Test resource not found!");
        }
        return resource;
    }
}
