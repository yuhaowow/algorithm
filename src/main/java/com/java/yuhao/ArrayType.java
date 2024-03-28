package com.java.yuhao;

import java.util.HashMap;
import java.util.Map;

public class ArrayType {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                res[0] = i;
                res[1] = map.get(a);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}


