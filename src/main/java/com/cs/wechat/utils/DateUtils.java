package com.cs.wechat.utils;

import org.apache.commons.lang3.StringUtils;

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

}

