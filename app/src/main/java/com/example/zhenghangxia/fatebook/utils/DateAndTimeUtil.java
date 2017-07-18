package com.example.zhenghangxia.fatebook.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhenghangxia on 17-7-17.
 *
 *  日期时间工具类
 *
 */

public class DateAndTimeUtil {

    static Calendar c = Calendar.getInstance();
//    public static int year = c.get(Calendar.YEAR);
//    public static int month = c.get(Calendar.MONTH);
//    public static int day = c.get(Calendar.DAY_OF_MONTH);

    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static String getTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sDateFormat.format(new Date());
    }

}
