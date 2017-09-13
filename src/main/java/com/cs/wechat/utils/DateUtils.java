package com.cs.wechat.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cs on 2017/8/10.
 */
public class DateUtils {

    public static final long ONE_DAY_LONG = 86400000;
    private static DateUtils classInstance = new DateUtils();

    public static DateUtils getInstance() {
        return classInstance;
    }
    public static Date string2Date(String str) {
        if (StringUtils.isEmpty(str))
            return new Date();
        return java.sql.Date.valueOf(str);
    }
    /**
     * 判断当前日期是星期几
     *
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

}

