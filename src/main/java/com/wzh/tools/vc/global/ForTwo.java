package com.wzh.tools.vc.global;

/**
 * @author wangzehui
 * @date 2018/9/19 19:46
 */

public class ForTwo {

    public static void main(String[] args) {
        Long kaishi = System.currentTimeMillis();
        for (int i = 0; i < 380; i++) {
            System.out.println("外层循环" + i);
            for (int j = 0; j < 380 * 3; j++) {
                System.out.println("内层循环" + j);
            }
        }
        Long jieshu = System.currentTimeMillis();
        System.out.println("调用时间" + (jieshu - kaishi) / 1000 + "秒");


    }


}