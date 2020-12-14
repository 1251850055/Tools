package com.wzh.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/9/5 10:59
 */

public class Test {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        int [] arr = {1,2,2,3,4,5,555,555};
        for (int i1 : arr) {
            map.put("数据", i1);
            System.out.println(JSONObject.toJSONString(map));
        }
    }


}
