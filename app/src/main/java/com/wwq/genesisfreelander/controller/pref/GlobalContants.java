package com.wwq.genesisfreelander.controller.pref;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by 001 on 2017/2/9.
 */

public class GlobalContants {
    /**
     * token
     */
    public static String TOKEN;
    /**
     * phoneNumber
     */
    public static String phoneNumber;
    /**
     * 是否重新请求
     */
    public static boolean isAnewRequest = false;
    /**
     * 左右集合标识，true为左，false为右
     */
    public static boolean isLeftRight = true;
    /**
     * 时间格式
     */
    public static final DateFormat DATEYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat DATEMMDD = new SimpleDateFormat("MM-dd");
    public static final DateFormat DATEHHMM = new SimpleDateFormat("hh:mm");
}
