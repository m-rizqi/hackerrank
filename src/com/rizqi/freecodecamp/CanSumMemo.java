package com.rizqi.freecodecamp;

import java.util.HashMap;
import java.util.Map;

public class CanSumMemo {
    public static void main(String[] args) {
        // no memo
        // System.out.println(canSumNoMemo(7, new Integer[]{2,3}));
        // System.out.println(canSumNoMemo(7, new Integer[]{5,3,4,7}));
        // System.out.println(canSumNoMemo(7, new Integer[]{2,4}));
        // System.out.println(canSumNoMemo(8, new Integer[]{2,3,5}));
        // System.out.println(canSumNoMemo(300, new Integer[]{7,14}));
        // with memo
        System.out.println(canSumMemo(7, new Integer[]{2,3}, new HashMap<Integer, Boolean>()));
        System.out.println(canSumMemo(7, new Integer[]{5,3,4,7}, new HashMap<Integer, Boolean>()));
        System.out.println(canSumMemo(7, new Integer[]{2,4}, new HashMap<Integer, Boolean>()));
        System.out.println(canSumMemo(8, new Integer[]{2,3,5}, new HashMap<Integer, Boolean>()));
        System.out.println(canSumMemo(300, new Integer[]{7,14}, new HashMap<Integer, Boolean>()));

    }
    static boolean canSumNoMemo(Integer n, Integer[] nums){
        if(n == 0){
            return true;
        }
        if(n < 0){
            return false;
        }
        boolean canSum = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > n)continue;
            Integer remain = n - nums[i];
            canSum |= canSumNoMemo(remain, nums);
        }
        return canSum;
    }

    static boolean canSumMemo(Integer n, Integer[] nums, Map<Integer, Boolean> memo) {
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if (n == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }
        boolean canSum = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > n){
                continue;
            }
            Integer remain = n - nums[i];
            canSum = canSumMemo(remain, nums, memo);
            if(canSum == true){
                memo.put(n, true);
                return true;
            }
        }
        memo.put(n, false);
        return canSum;
    }
}
