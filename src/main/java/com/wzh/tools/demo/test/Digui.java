package com.wzh.tools.demo.test;

public class Digui {
    public static void main(String[] args) {
        add(1);
        System.out.println(add(1));
    }


    public static int add(int i) {
        if (i > 0 && i < 100) {
            return i + add(i + 1);
        } else {
            return i;
        }
    }


}
