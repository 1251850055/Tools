package com.wzh.tools;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/9/5 10:59
 */

public class Test {

    public static void main(String[] args) {
        String s = "{\"bookId\":437,\"courseId\":\"02\",\"errorNum\":1,\"studentId\":386,\"type\":2}";

        JSONObject jsonObject = JSONObject.parseObject(s);


        String bookId = jsonObject.get("bookId").toString();

        System.out.println(bookId);


    }


}
