package com.book.entity.type;

import com.book.common.DateUtils;
import com.book.common.Extend;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Zhao Jinyan
 * @date 2019-03-23
 */
public class AccountDate {

    private final static String EMPTY_ACCOUNT_DATE_STRING = "00000000";

    private static Map<String, AccountDate> cache = new HashMap<>();

    public static AccountDate of(Date date) {
        return of(DateUtils.SIMPLE_DATE_FORMAT.format(date));
    }

    public  static AccountDate of(String dateString) {
        return Extend.isNull(cache.get(dateString), () -> Extend.with(new AccountDate(dateString), date -> cache.put(dateString, date)));
    }

    private String dateString;

    private Date date;

    private String year = null;

    private String month = null;

    private String day = null;

    @Deprecated
    public AccountDate(Date date) {
        this(DateUtils.SIMPLE_DATE_FORMAT.format(date));
    }

    private AccountDate(String dateString) {
        this.dateString = Objects.isNull(dateString) || dateString.length() < 8
            ? EMPTY_ACCOUNT_DATE_STRING : dateString;
    }

    private void resolve() {
        year = dateString.substring(0, 4);
        month = dateString.substring(4, 6);
        day = dateString.substring(6, 8);
        try {
            date = DateUtils.SIMPLE_DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            date = null;
        }
    }

    public Date getDate() {
        Extend.ifNull(date, this::resolve);
        return date;
    }

    public String getYear() {
        Extend.ifNull(date, this::resolve);
        return year;
    }

    public String getMonth() {
        Extend.ifNull(date, this::resolve);
        return month;
    }

    public String getDay() {
        Extend.ifNull(date, this::resolve);
        return day;
    }

    private String getDateString() {
        return dateString;
    }

    @Override
    public int hashCode() {
        return dateString.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AccountDate) {
            return dateString.equals(((AccountDate) obj).getDateString());
        }
        return false;
    }

    @Override
    public String toString() {
        return dateString;
    }
}
