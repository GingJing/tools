package com.mingyu.utils;

/**
 * 字符串工具类
 *
 * @date: 2020/9/27 8:44
 * @author: GingJingDM
 * @version: 1.0
 */
public class StringUtil {

    /**
     * 是否为空串
     *
     * @param str 校验的对象
     * @return 如果str为null或者equals方法与空字符串相等则返回true，否则false
     */
    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    /**
     * 是否字符串序列有值
     *
     * @param str 校验的字符串序列
     * @return 如果字符串序列不为null且长度大于1则返回true，否则false
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    /**
     * 字符串序列是否有文本
     *
     * @param str 字符串
     * @return 如果含有非空格文本则返回true，否则返回false
     */
    public static boolean hasText(CharSequence str) {
        return (str != null && str.length() > 0 && containsText(str));
    }

    /**
     * 含有文本，即排除空格
     *
     * @param str 校验字符序列
     * @return 含有非空格字符则返回true，否则返回false
     */
    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串序列是否含有空格
     *
     * @param str 校验的字符串序列
     * @return 有空格则true，否则false
     */
    public static boolean containsWhitespace(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }

        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}
