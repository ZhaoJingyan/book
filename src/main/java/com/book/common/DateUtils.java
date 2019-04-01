package com.book.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期通用方法
 *
 * @author Zhao Jinyan
 * @date 2019-03-25
 */
public class DateUtils {

    /**
     * 简单日期格式, yyyyMMdd
     */
    public final static DateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static Date getYesterday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

}
