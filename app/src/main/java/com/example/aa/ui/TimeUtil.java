package com.example.aa.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by fanhengbiao on 16-9-27.
 */

public class TimeUtil {
    /**
     * 获取当前时间
     *
     * @param format "yyyy-MM-dd HH:mm:ss"
     */
    public static String getCurrentTime(String format) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return simpleDateFormat.format(date);
    }
    /**
     * 获取当前时间为本月的第几周
     */
    public static int getWeekOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week - 1;
    }
    /**
     * 获取当前时间为本周的第几天
     */
    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            day = 7;
        } else {
            day = day - 1;
        }
        return day;
    }
    /**
     * 获取当前时间的年份
     */
    public static int getYear() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
    /**
     * 获取当前时间的月份
     */
    public static int getMonth() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }
    /**
     * 获取当前时间是哪天
     */
    public static int getDay() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.DATE);
    }
    /**
     * @param date1
     * @param date2
     * @return 1:date1大于date2；
     * -1:date1小于date2
     */
    public static int compareDate(String date1, String date2, String format) {
        DateFormat df = new SimpleDateFormat(format, Locale.getDefault());
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    /**
     * 时间加减
     *
     * @param day       如"2015-09-22"
     * @param dayAddNum 加减值
     * @return
     */
    public static String timeAddSubtract(String day, int dayAddNum) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date newDate = new Date(simpleDateFormat.parse(day).getTime() + dayAddNum * 24 * 60 * 60 * 1000);
            return simpleDateFormat.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 毫秒格式化
     *
     * @param millisecond 如"1449455517602"
     * @param format 如"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String millisecond2String(long millisecond, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return simpleDateFormat.format(millisecond);
    }
    /**
     * 计算时间差   传入的是毫秒数
     *
     * @param starTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @param
     *             ==1----天，时，分。 ==2----时
     * @return 返回时间差
     */
    public String getTimeDifference(String starTime, String endTime) {
        String timeString = "";

        long longend = Long.parseLong(endTime);
        long longstart = Long.parseLong(starTime);
        if (longend <= longstart|| (longend-longstart)<1000) {
            return "0小时0分0秒";
        }

        long diff = longend - longstart;

        long day = diff / (24 * 60 * 60 * 1000);
        long hour = (diff / (60 * 60 * 1000) - day * 24);
        long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long hour1 = diff / (60 * 60 * 1000);
        timeString = hour + "小时" + min + "分"+s+"秒";

        return timeString;

    }
}
