package com.wzh.tools;


/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/9/29 8:59
 */

public class Test {
    public static void main(String[] args) {

        String[] s = {"a","b", "c", "d", "e" };

        String join = String.join(",", s);

        System.out.println(join);
    }
}
