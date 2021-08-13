package com.kanq.common.utils;

/**
 * 正则表达式工具类
 */



public class RegexUtil {
    /**
     * 用户名正则，4到16位（字母，数字，下划线，减号）
     */
    public static final String ACCOUNT_REG="^[a-zA-Z0-9_-]{4,16}$";

    /**
     * 密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
     */
    public static final String PASSWORD_REG="^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$";



}
