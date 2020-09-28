package com.mingyu.utils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 对象工具类
 *
 * @date: 2020/9/27 8:43
 * @author: GingJingDM
 * @version: 1.0
 */
public class ObjectUtil {

    private ObjectUtil() {
    }

    /**
     * 是否为空
     *
     * @param obj 对象
     * @return null或者长度为0返回true，否则返回false
     */
    public static boolean isEmpty(Object obj) {
        if (isNull(obj)) {
            return true;
        }
        if (obj instanceof Optional) {
            return !((Optional) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 数组有元素返回true，否则返回false
     */
    public static boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 是否含有非空元素
     *
     * @param obj 校验对象
     * @return 本身或者元素全部为null或空白串则返回false，否则true
     */
    public static boolean hasNonEmptyElement(Object obj) {
        if (isNull(obj)) {
            return false;
        }
        if (obj instanceof CharSequence) {
            return StringUtil.hasText((CharSequence) obj);
        }
        if (obj instanceof Optional) {
            if (!((Optional) obj).isPresent()) {
                return false;
            } else {
                return hasNonEmptyElement(((Optional) obj).get());
            }
        }
        if (obj.getClass().isArray()) {
            return hasNonEmptyElement(Arrays.asList(obj));
        }
        if (obj instanceof Collection) {
            if (((Collection) obj).isEmpty()) {
                return false;
            }
            for (Object o : ((Collection) obj)) {
                if (hasNonEmptyElement(o)) {
                    return true;
                }
            }
        }
        if (obj instanceof Map) {
            if (((Map) obj).isEmpty()) {
                return false;
            }
            for (Object value : ((Map) obj).values()) {
                if (hasNonEmptyElement(value)) {
                    return true;
                }
            }
        }
        if (obj instanceof Iterable) {
            for (Object o : (Iterable) obj) {
                if (hasNonEmptyElement(o)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * 是否为null
     *
     * @param obj 对象
     * @return null 返回true，否则返回false
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 是否是数组
     *
     * @param obj 校验对象
     * @return 是数组 true，否则false
     */
    public static boolean isArray(Object obj) {
        return (obj != null && obj.getClass().isArray());
    }


}
