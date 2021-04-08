package com.wzh.tools;

import com.wzh.tools.demo.java.thread.ManualCreate;

/**
 * @Author: wangzehui
 * @Date: 2020/9/5 10:59
 */

public class Test {

    public static void main(String[] args) {
        ManualCreate manualCreate = new ManualCreate();
        manualCreate.init();
        System.out.println("测试修改Github用户姓名影响");
    }
}
