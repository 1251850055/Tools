package com.wzh.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/8/4 16:45
 */

public class Test {

    public static final String pattern = "M-dd";

    public static void main(String[] args) {

        try {
            Date date = new Date();
            DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
            System.out.println(df1.format(date));

            SimpleDateFormat df = new SimpleDateFormat(pattern);
            String format = df.format(date);

            Date parse = df.parse(df1.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}
