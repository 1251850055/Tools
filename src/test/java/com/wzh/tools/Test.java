package com.wzh.tools;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/8/4 16:45
 */

public class Test {
    public static void main(String[] args) {
        String s = computeA(0, 3);
        System.out.println(s);
    }

    public static String computeA(int a, int b) {
        if (0 != a && 0 != b) {
            BigDecimal num = new BigDecimal((float) a / b).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            if (num.compareTo(ZERO) <= 0) {
                num = ZERO;
            }
            String str = num.stripTrailingZeros().toPlainString();
            return str + "%";
        } else {
            return "0.00%";
        }
    }


}
