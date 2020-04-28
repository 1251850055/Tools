package com.wzh.tools.demo.java.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2018/12/16 18:50
 */

public class Abnormal {
    public static void main(String[] args) {
        try {
            boolean a = true;
            if (a) {
                throw new RuntimeException("手动抛异常创建失败");
            } else {
                System.out.println("程序执行");
            }
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            System.out.println(stringWriter.toString());

            System.out.println(e);
        }
    }
}
