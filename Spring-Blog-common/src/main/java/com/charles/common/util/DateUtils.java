package com.charles.common.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期操作类
 *
 */
public class DateUtils {

    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String YYYYMMDDS = "yyyyMMdd";
    public static final String YYYYMMDDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDHM = "yyyy-MM-dd HH:mm";
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private DateUtils() {
    }


    public static String format(Date date) {
        return format(date, YYYYMMDD);
    }


    public static Date parse(String dateStr, String dateFormat) throws ParseException {
        threadLocal.get().applyPattern(dateFormat);
        return threadLocal.get().parse(dateStr);
    }

    /**
     * 将日期类型转换成指定格式的日期字符串
     *
     * @param date       待转换的日期
     * @param dateFormat 日期格式字符串
     * @return String
     */
    public static String format(Date date, String dateFormat) {
        if (StringUtils.isEmpty(dateFormat) || date == null) {
            threadLocal.get().applyPattern(YYYYMMDDHMS);
            return threadLocal.get().format(new Date());
        }
        threadLocal.get().applyPattern(dateFormat);
        return threadLocal.get().format(date);
    }

    /**
     * 将指定格式的字符串转换成日期类型
     *
     * @param dateStr    待转换的日期字符串
     * @param dateFormat 日期格式字符串
     * @return Date
     */
    public static Date toDate(String dateStr, String dateFormat) {
        if (dateStr == null || "".equals(dateStr)) {
            return null;
        }
        try {
            return parse(dateStr, dateFormat);
        } catch (Exception e) {
            logger.error("error in toDate :{}", e);
        }
        return null;
    }

    public static Date toDate(String str) {
        if (StringUtils.isEmpty(str)) {
            return toDate("1900-01-01", YYYYMMDD);
        }
        return toDate(str, YYYYMMDD);
    }

    public static Date toDate2(String str) {
        String dateFormat = YYYYMMDD;
        // 2012-01-01 00:00:00格式
        if (str.matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}")) {
            dateFormat = YYYYMMDDHMS;
            // 2012-01-01 00:00格式
        } else if (str.matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}")) {
            dateFormat = YYYYMMDDHM;
        }
        return toDate(str, dateFormat);
    }

    /**
     * 根据指定年度和月份获取月初日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 根据指定年度和月份获取月初日期
     *
     * @param yearMonth
     * @return
     */
    public static Date getFirstDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, yearMonth.length()));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 根据指定年度和月份获取月末日期
     *
     * @param yearMonth
     * @return
     */
    public static Date getLastDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, yearMonth.length()));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);

        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.set(Calendar.DAY_OF_MONTH, maxDay);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 根据指定年度和月份获取月末日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);

        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.set(Calendar.DAY_OF_MONTH, maxDay);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getFirstDateOfThisYear() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MONTH, 0);
        ca.set(Calendar.DATE, 1);
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        return ca.getTime();
    }


    /**
     * 获取指定日期的月
     *
     * @param date
     * @return
     */
    public static int getMonthOfDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Invalid argument, date is null in getMonthOfDate");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取指定日期的季度
     *
     * @param date
     * @return
     */
    public static int getQuarterOfDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Invalid argument, date is null in getQuarterOfDate");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH) + 1;
        return getQuarter(month);

    }

    private static int getQuarter(int month) {
        int quarter = 1;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        }
        if (month >= 4 && month <= 6) {
            quarter = 2;
        }
        if (month >= 7 && month <= 9) {
            quarter = 3;
        }
        if (month >= 10 && month <= 12) {
            quarter = 4;
        }
        return quarter;
    }

    /**
     * 获取指定日期所在月份的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("Invalid argument, date is null");
        }

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        int maxDay = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar1.set(Calendar.DAY_OF_MONTH, maxDay);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        return calendar1.getTime();
    }

    /**
     * 获取指定日期所在月份的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("Invalid argument, date is null");
        }

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        return calendar1.getTime();
    }


    /**
     * 比较两个日期之间的天数差异，例如：如果left比right晚一天，返回1，如果相等返回0， 如果left比right早一天，返回-1
     *
     * @param left
     * @param right
     * @return int 差异天数
     */
    public static int getDiffDays(Date left, Date right) {
        GregorianCalendar leftCaldr = new GregorianCalendar();
        GregorianCalendar rightCaldr = new GregorianCalendar();
        leftCaldr.setTime(left);
        rightCaldr.setTime(right);

        leftCaldr.set(GregorianCalendar.HOUR_OF_DAY, 0);
        leftCaldr.set(GregorianCalendar.MINUTE, 0);
        leftCaldr.set(GregorianCalendar.SECOND, 0);
        leftCaldr.set(GregorianCalendar.MILLISECOND, 0);

        rightCaldr.set(GregorianCalendar.HOUR_OF_DAY, 0);
        rightCaldr.set(GregorianCalendar.MINUTE, 0);
        rightCaldr.set(GregorianCalendar.SECOND, 0);
        rightCaldr.set(GregorianCalendar.MILLISECOND, 0);

        long leftMilSec = leftCaldr.getTimeInMillis();
        long rightMilSec = rightCaldr.getTimeInMillis();

        long res = (leftMilSec - rightMilSec) / (24L * 60L * 60L * 1000L);

        return (int) res;
    }


    /**
     * 得到相差offset天的时间
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date getDateByOffset(Date date, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, offset);
        return cal.getTime();
    }

    public static final int getDayOfWeek(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static Date clearTime(Date date) {
        if (date == null) {
            return null;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    /**
     * getDateDiffDays
     *
     * @param curDate
     * @param oriDate
     * @return int
     * @author henry_li
     * @since 2006-12-28
     */
    public static int getDateDiffDays(Date curDate, Date oriDate) {
        return Math.abs(getDateDiffDay(curDate, oriDate));
    }

    /**
     * 计算时间差,>0表示当前开始日期为明天, <0表示当前开始日期是昨天
     *
     * @param curDate
     * @param oriDate
     * @return
     */
    public static int getDateDiffDay(Date curDate, Date oriDate) {
        final int msPerDay = 1000 * 60 * 60 * 24;
        Date startDate = new Date();
        Date endDate = new Date();

        try {
            startDate = new SimpleDateFormat(YYYYMMDD).parse(getDate(curDate));
            endDate = new SimpleDateFormat(YYYYMMDD).parse(getDate(oriDate));
        } catch (ParseException ex) {
            logger.error("error in getDateDiffDay:{}", ex);
        }

        return (int) (startDate.getTime() - endDate.getTime()) / msPerDay;
    }

    public static String getDate(Date date) {
        return getDate(date, YYYYMMDD);
    }

    /**
     * @param date
     * @param pattern
     * @return
     */
    public static String getDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 得到相差offset月的时间
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date getMonthByOffset(Date date, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, offset);
        return cal.getTime();
    }

    public static boolean isBetween(Date beginDate, Date endDate, Date date) {
        int offsetAll = getDiffDays(endDate, beginDate);
        int offsetBegin = getDiffDays(date, beginDate);
        int offsetEnd = getDiffDays(endDate, date);
        return offsetBegin <= offsetAll && offsetEnd <= offsetAll;
    }

    /**
     * 将long类型转化为Date
     *
     * @param l long
     * @return date
     * @throws ParseException
     */
    public static Date longToDate(long l) {
        return new Date(l * 1000);
    }
}
