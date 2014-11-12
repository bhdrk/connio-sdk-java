package com.connio.sdk.http.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by bdirik on 07.11.2014.
 */
public class DateUtils {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtils.class);

    private static final SimpleDateFormat ISO8601_FORMAT;

    static {
        ISO8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        ISO8601_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public static Date parseStringToDate(String str) {
        try {
            return ISO8601_FORMAT.parse(str);
        } catch (ParseException e) {
            if (LOG.isInfoEnabled())
                LOG.info(e.getMessage(), e);

            return null;
        }
    }
}
