package com.wzh.tools.demo.efficiencycode;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/4/22 10:15
 */

public class Test {

    private static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }


    public static void main(String[] args) {
        Boolean aBoolean = Test.valueOf(false);
        System.out.println(aBoolean);
    }

}
