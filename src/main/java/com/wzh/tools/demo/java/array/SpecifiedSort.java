package com.wzh.tools.demo.java.array;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2019/6/26 17:24
 */

public class SpecifiedSort {
    public static String getFilmType(String filmType) {
        String[] s = {"中国巨幕2K", "4K", "2K", "4D", "ATMOS", "IMAX3D", "巨幕3D", "IMAX", "巨幕", "3D"};
        String[] split = filmType.split(",");
        StringBuilder a = new StringBuilder();
        if (split.length > 0) {
            for (String value : s) {
                for (String s1 : split) {
                    if (s1.equals(value)) {
                        a.append(" ").append(value);
                        break;
                    }
                }
            }
            return a.toString();
        }
        return "";
    }


    public static void main(String[] args) {
        String filmType = getFilmType("3D,2K,中国巨幕2K").trim();
        System.out.println(filmType);
    }
}
