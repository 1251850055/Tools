package com.wzh.tools;

import com.wzh.tools.utils.time.StringUtil;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/8/4 16:45
 */

public class Test {

    public static final String[] character = {"校长15", "学校管理员10", "年级长13", "学科组长20", "班主任12", "学科教师11"};

    public static void main(String[] args) {
//        String maxRole = getMaxRole("学校管理员10,年级长13,学科教师11,校长15");
        String maxRole1 = getMaxRole("10,年级长13,学科教师11,15");
//        System.out.println(maxRole);
        System.out.println(maxRole1);
    }


    public static String getMaxRole(String roleStr) {
        String[] split = roleStr.split(",");
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (null != split && split.length > 0) {
            for (String value : character) {
                for (String s1 : split) {
                    if (s1.equals(value)) {
                        sb.append(value).append(",");
                        break;
                    }
                }
            }
            if (StringUtil.isNotEmpty(sb.toString())) {
                String[] split1 = sb.toString().split(",");
                if (null != split1 && split1.length > 0) {
                    if (StringUtil.isNotEmpty(split1[0])) {
                        str = split1[0];
                    }

                }
            }
        }
        return str;
    }

}
