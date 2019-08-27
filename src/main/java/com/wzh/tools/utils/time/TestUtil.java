package com.wzh.tools.utils.time;/*
package cn.vcfilm.sts.statistics;

import cn.vcfilm.sts.order.statistics.api.OrderBusinessService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

*/
/**
 * @author wangzehui
 * @date 2018/6/9 10:52
 *//*


public class TestTime {


    public static void main1 (String[] args){
//        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
//        Date todayDate = new Date();
//        try {
//            todayDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01"); //将一个Date数据写死
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(todayDate);
//        //2014年5月1日毫秒值
//        long time2014 = 1400860800000L;
//        int i = 0;
//        while (todayDate.getTime() > time2014) {
//            String timeStr = format.format(todayDate);
//            String[] split = timeStr.split("-");
//            calendar.add(Calendar.DATE, -1);
//            todayDate = calendar.getTime();
//            i++;
//            System.out.println(timeStr);
//
//        }
//        System.out.println("一共多少天：" + i);




//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        //此处会抛异常
//        Date date = null;
//        try {
//            date = sdf.parse("2015-01-01");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        //获取毫秒数
//        long longDate = date.getTime();
//        System.out.println(longDate);

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        Date todayDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todayDate);
        //2015年1月1日毫秒值
        long time2014 = 1420041600000L;
        while (todayDate.getTime() > time2014) {
            String timeStr = format.format(todayDate);
            System.out.println(timeStr);
//            String[] split = timeStr.split("-");
            calendar.add(Calendar.DATE, -1);
            todayDate = calendar.getTime();

//            try {
//                Thread.sleep(1);
//                BoxOfficeStatisticsData dataDay = orderBusinessService.queryBoxOffice(timeStr, typeDay);
//                Thread.sleep(2);
//                BoxOfficeStatisticsData dataMonth = orderBusinessService.queryBoxOffice(timeStr, typeMonth);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }
    }
    public static void main(String[] args){
        Date todayDate = null; //将一个Date数据写死
        try {
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
            todayDate = todayDate = new SimpleDateFormat("yyyy-MM-dd").parse("2017-01-01");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(todayDate);
            calendar.add(Calendar.DATE, -1);
            todayDate = calendar.getTime();
            String timeStr = format.format(todayDate);
            System.out.println(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
*/
/**
 *
 *  文 件 名: AccountDate.java
 *
 *  创建时间: 2008-11-18
 *
 *  Email  : **@163.com
 */

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUtil {

    private static transient int gregorianCutoverYear = 1582;

    /** 闰年中每月天数 */
    private static final int[] DAYS_P_MONTH_LY= {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /** 非闰年中每月天数 */
    private static final int[] DAYS_P_MONTH_CY= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /** 代表数组里的年、月、日 */
    private static final int Y = 0, M = 1, D = 2;

    /**
     * 将代表日期的字符串分割为代表年月日的整形数组
     * @param date
     * @return
     */
    public static int[] splitYMD(String date){
        date = date.replace("-", "");
        int[] ymd = {0, 0, 0};
        ymd[Y] = Integer.parseInt(date.substring(0, 4));
        ymd[M] = Integer.parseInt(date.substring(4, 6));
        ymd[D] = Integer.parseInt(date.substring(6, 8));
        return ymd;
    }

    /**
     * 检查传入的参数代表的年份是否为闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return year >= gregorianCutoverYear ?
                ((year%4 == 0) && ((year%100 != 0) || (year%400 == 0))) : (year%4 == 0);
    }

    /**
     * 日期加1天
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static int[] addOneDay(int year, int month, int day){
        if(isLeapYear( year )){
            day++;
            if( day > DAYS_P_MONTH_LY[month -1 ] ){
                month++;
                if(month > 12){
                    year++;
                    month = 1;
                }
                day = 1;
            }
        }else{
            day++;
            if( day > DAYS_P_MONTH_CY[month -1 ] ){
                month++;
                if(month > 12){
                    year++;
                    month = 1;
                }
                day = 1;
            }
        }
        int[] ymd = {year, month, day};
        return ymd;
    }

    /**
     * 将不足两位的月份或日期补足为两位
     * @param decimal
     * @return
     */
    public static String formatMonthDay(int decimal){
        DecimalFormat df = new DecimalFormat("00");
        return df.format( decimal );
    }

    /**
     * 将不足四位的年份补足为四位
     * @param decimal
     * @return
     */
    public static String formatYear(int decimal){
        DecimalFormat df = new DecimalFormat("0000");
        return df.format( decimal );
    }

    /**
     * 计算两个日期之间相隔的天数
     * @param begin
     * @param end
     * @return
     * @throws ParseException
     */
    public static long countDay(String begin,String end){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate , endDate;
        long day = 0;
        try {
            beginDate= format.parse(begin);
            endDate=  format.parse(end);
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 以循环的方式计算日期
     * @param beginDate endDate
     * @param days
     * @return
     */
    public static List<String> getEveryday(String beginDate , String endDate){
        long days = countDay(beginDate, endDate);
        int[] ymd = splitYMD( beginDate );
        List<String> everyDays = new ArrayList<String>();
        everyDays.add(beginDate);
        for(int i = 0; i < days; i++){
            ymd = addOneDay(ymd[Y], ymd[M], ymd[D]);
            everyDays.add(formatYear(ymd[Y])+"-"+formatMonthDay(ymd[M])+"-"+formatMonthDay(ymd[D]));
        }
        return everyDays;
    }

    public static void main(String[] args) {
        List<String> list = TestUtil.getEveryday("2010-01-01", "2018-06-09");
        int i = 0;
        for (String result : list) {
            System.out.println(result);
            i++;
        }
        System.out.println(i);
    }

}