package com.mingyu.enums;

import com.mingyu.constants.DateConstants;

import java.time.MonthDay;
import java.util.Objects;

/**
 * 星座枚举
 *
 * @date: 2020/9/25 16:42
 * @author: GingJingDM
 * @version: 1.0
 */
public enum  ConstellationEnum {
    Aries(1, "白羊座", "03-21", "04-19"),
    Taurus(2, "金牛座", "04-20", "05-20"),
    Gemini(3, "双子座", "05-21", "06-21"),
    Cancer(4, "巨蟹座", "06-22", "07-22"),
    Leo(5, "狮子座", "07-23", "08-22"),
    Virgo(6, "处女座", "08-23", "09-22"),
    Libra(7, "天秤座", "09-23", "10-23"),
    Scorpio(8, "天蝎座", "10-24", "11-22"),
    Sagittarius(9, "射手座", "11-23", "12-21"),
    Capricorn(10, "摩羯座", "12-22", "01-19"),
    Aquarius(11, "水瓶座", "01-20", "02-18"),
    Pisces(12, "双鱼座", "02-19", "03-20"),
    ;

    /** 序号 */
    private final int code;

    /** 名称 */
    private final String cnName;

    /** 开始时间 */
    private final String startDate;

    /** 结束时间 */
    private final String endDate;

    ConstellationEnum(int code, String cnName, String startDate, String endDate) {
        this.code = code;
        this.cnName = cnName;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    /**
     * 根据星座名称获取星座枚举，传入中文或英文名均可，但是不能是空值
     *
     * @return ConstellationEnum 星座枚举
     */
    public static ConstellationEnum getByName(String name) {
        Objects.requireNonNull(name, "Constellation name");
        for (ConstellationEnum constellationEnum : ConstellationEnum.values()) {
            if (constellationEnum.getCnName().equals(name)) {
                return constellationEnum;
            } else if (constellationEnum.name().equalsIgnoreCase(name)) {
                return constellationEnum;
            }
        }
        return null;
    }

    /**
     * 根据月份日期获取星座枚举
     *
     * @param monthDayStr 日期字符串
     * @return  ConstellationEnum 星座枚举
     */
    public static ConstellationEnum getByMonthDay(String monthDayStr) {
        Objects.requireNonNull(monthDayStr, "monthDayStr");
        MonthDay monthDay = MonthDay.parse(DateConstants.MONTHDAY_FORMAT_PRE + monthDayStr);
        for(ConstellationEnum constellationNameEnum : ConstellationEnum.values()){
            if(constellationNameEnum.getStartDate().equals(monthDayStr)||constellationNameEnum.getEndDate().equals(monthDayStr)){
                return constellationNameEnum;
            }
            MonthDay monthDayStart = MonthDay.parse(DateConstants.MONTHDAY_FORMAT_PRE + constellationNameEnum.getStartDate());
            MonthDay monthDayEnd = MonthDay.parse(DateConstants.MONTHDAY_FORMAT_PRE + constellationNameEnum.getEndDate());

            if (monthDay.isAfter(monthDayStart) && monthDay.isBefore(monthDayEnd)) {
                return constellationNameEnum;
            }
        }
        return null;
    }

    /**
     * 根据日期查询星座中文名称
     *
     * @param monthDayStr MM-dd格式
     * @return String
     */
    public static String getCnNameByMonthDay(String monthDayStr){
        ConstellationEnum constellationEnum = getByMonthDay(monthDayStr);
        return constellationEnum != null ? constellationEnum.getCnName() : null;
    }

    /**
     * 根据日期查询星座英文名称
     *
     * @param monthDayStr MM-dd格式
     * @return String
     */
    public static String getEnNameByMonthDay(String monthDayStr){
        ConstellationEnum constellationEnum = getByMonthDay(monthDayStr);
        return constellationEnum != null ? constellationEnum.name() : null;
    }


    public int getCode() {
        return code;
    }

    public String getCnName() {
        return cnName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
