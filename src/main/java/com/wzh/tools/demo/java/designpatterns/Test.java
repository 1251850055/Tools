package com.wzh.tools.demo.java.designpatterns;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/11/7 10:47
 */

public class Test {
    public static void main(String[] args) {
        Single instance = Single.getInstance();
        instance.showMessage();
    }
}
