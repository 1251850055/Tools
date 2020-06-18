package com.wzh.tools.demo.java.thread;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/4/22 11:39
 */

public class TestThread {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();
    }
}
