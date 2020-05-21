package com.wzh.tools;

import org.apache.commons.lang.StringUtils;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/4/26 9:38
 */

public class Test {
    public static void main(String[] args) {
        System.out.println((int)((Math.random() * 899999) + 100000));

        System.out.println(StringUtils.isNotBlank("123"));
    }
}
