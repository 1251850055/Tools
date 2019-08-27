package com.wzh.tools.demo.efficiencycode;

/**
 * @author wangzehui
 * @date 2018/10/19 13:47
 */

public class Obj {
    public static void main(String[] args) {

        String[] str1 = {"1,2,3,4,5"};
        System.out.println("str1地址" + str1);

        String[] str2 = str1.clone();
        System.out.println("str2地址" + str2);

        String[] str3 = {"1,2,3,4,5"};

        for (String s : str1) {
            System.out.println(s);
        }

        for (String s : str2) {
            System.out.println(s);
        }

        System.out.println(str1.hashCode());

        System.out.println(str2.hashCode());

        System.out.println("str1和str2值是否相等" + str1.equals(str2));

        System.out.println(str1 == str2);




    }
}
