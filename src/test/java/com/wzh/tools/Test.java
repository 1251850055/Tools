package com.wzh.tools;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/9/29 8:59
 */

public class Test {
    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();

        System.out.println(objects.isEmpty());

        System.out.println(CollectionUtils.isEmpty(objects));
    }
}
