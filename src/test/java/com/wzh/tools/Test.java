package com.wzh.tools;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/5/28 16:02
 */

public class Test {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4"};
        StringBuilder a = new StringBuilder();
        for (String s : arr) {
            a.append(",").append(s);
        }
        a = new StringBuilder(a.substring(1, a.length()));
        DataA data1 = new DataA();
        data1.setData(a.toString());
        String s = JSONObject.toJSONString(data1);
        System.out.println(s);

    }
}
