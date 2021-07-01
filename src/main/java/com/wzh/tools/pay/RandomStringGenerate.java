package com.wzh.tools.pay;

import java.util.Random;

/**
 * @Description: 获取指定长度的随机字符串
 * @Author: wangzehui
 * @Date: 2021/6/26 4:28 下午
 */
public class RandomStringGenerate {

    public static void main(String[] args) {
        String str = getRandomStringByLength(32);
        System.out.println(str);

    }

    public static  String getRandomStringByLength(int length){
        String base = "abcdefghijklmnopqrstuvwsyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
