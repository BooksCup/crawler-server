package com.bc.crawler.server.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zhou
 */
public class TimeUtil {
    /**
     * 获取指定日期的起始时间
     */
    public static Date getDateStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取指定日期的结束时间
     */
    public static Date getDateEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }
}
