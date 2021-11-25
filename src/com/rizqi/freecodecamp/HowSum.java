package freecodecamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HowSum {

    public static void main(String[] args) {
        // no memo
        // System.out.println(Arrays.toString(howSumNoMemo(7, new Integer[] { 2, 3})));;
        // System.out.println(Arrays.toString(howSumNoMemo(7, new Integer[] { 5, 3, 4, 7 })));;
        // System.out.println(Arrays.toString(howSumNoMemo(7, new Integer[] { 2, 4 })));;
        // System.out.println(Arrays.toString(howSumNoMemo(8, new Integer[] { 2, 3, 5 })));;
        // System.out.println(Arrays.toString(howSumNoMemo(300, new Integer[] {7, 14 })));;
        // with memo
        Optional.ofNullable(howSumMemo(7, Arrays.asList( 2, 3 ), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v -> {System.out.println(Arrays.toString(v.toArray()));}, () -> {System.out.println("null");});
        Optional.ofNullable(howSumMemo(7, Arrays.asList( 5, 3, 4, 7 ), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v -> {System.out.println(Arrays.toString(v.toArray()));}, () -> {System.out.println("null");});
        Optional.ofNullable(howSumMemo(7, Arrays.asList( 2, 4 ), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v -> {System.out.println(Arrays.toString(v.toArray()));}, () -> {System.out.println("null");});
        Optional.ofNullable(howSumMemo(8, Arrays.asList( 2, 3, 5 ), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v -> {System.out.println(Arrays.toString(v.toArray()));}, () -> {System.out.println("null");});
        Optional.ofNullable(howSumMemo(300, Arrays.asList( 7, 14 ), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v -> {System.out.println(Arrays.toString(v.toArray()));}, () -> {System.out.println("null");});
    }
    static Integer[] howSumNoMemo(Integer n, Integer[] nums){
        if(n == 0){
            return new Integer[]{};
        }
        if(n < 0){
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            Integer remain = n - nums[i];
            Integer[] temp = howSumNoMemo(remain, nums);
            if(temp != null){
                Integer[] result = new Integer[temp.length+1];
                for (int j = 0; j < temp.length; j++) {
                    result[j] = temp[j];
                }
                result[result.length - 1] = nums[i];
                return result;
            }
        }
        return null;
    }

    static List<Integer> howSumMemo(Integer n, List<Integer> nums, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(n)){return memo.get(n);}
        if(n == 0){return new ArrayList<Integer>();}
        if(n < 0){return null;};

        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) > n){continue;}
            Integer remain = n - nums.get(i);
            List<Integer> remainRes = howSumMemo(remain, nums, memo);
            if(remainRes != null){
                remainRes.add(nums.get(i));
                memo.put(n, remainRes);
                return memo.get(n);
            }
        }
        memo.put(n, null);
        return null;
    }
}
