package com.wzh.tools.letcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 从数组找出 两数之和等于一个目标数 返回下标
 * @Author: wangzehui
 * @Date: 2020/6/16 13:38
 */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 7, 4, 10, 8};
        int target = 8;
        int[] ints = twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}
