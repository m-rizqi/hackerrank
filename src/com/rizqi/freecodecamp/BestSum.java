package com.rizqi.freecodecamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        // no memo
        // Optional.ofNullable(bestSumNoMemo(7, Arrays.asList(5,3,4,7))).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
        // Optional.ofNullable(bestSumNoMemo(8, Arrays.asList(2,3,5))).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
        // Optional.ofNullable(bestSumNoMemo(8, Arrays.asList(1,4,5))).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
        // Optional.ofNullable(bestSumNoMemo(100, Arrays.asList(1,2,5,25))).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
        // with memo
        Optional.ofNullable(bestSumMemo(7, Arrays.asList(5,3,4,7), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
        Optional.ofNullable(bestSumMemo(8, Arrays.asList(2,3,5), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
        Optional.ofNullable(bestSumMemo(8, Arrays.asList(1,4,5), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
        Optional.ofNullable(bestSumMemo(100, Arrays.asList(1,2,5,25), new HashMap<Integer, List<Integer>>())).ifPresentOrElse(v->{System.out.println(Arrays.toString(v.toArray()));}, ()->{System.out.println("null");});
    }
    static List<Integer> bestSumNoMemo(Integer n, List<Integer> nums){
        if(n == 0){return new ArrayList<Integer>();}
        if(n < 0){return null;}

        List<Integer> shortest = null;
        for (int i = 0; i < nums.size(); i++) {
            Integer nInteger = nums.get(i);
            if(nInteger > n){continue;}
            Integer remain = n - nInteger;
            List<Integer> result = bestSumNoMemo(remain, nums);
            if(result != null){
                result.add(nInteger);
                if(shortest == null){
                    shortest = new ArrayList<>();
                    shortest = result;
                }else if(result.size() < shortest.size()){
                    shortest = result;
                }
            }
        }
        return shortest;
    }
    
    static List<Integer> bestSumMemo(Integer n, List<Integer> nums, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n == 0){return new ArrayList<Integer>();}
        if(n < 0){return null;}

        List<Integer> shortest = null;
        for (int i = 0; i < nums.size(); i++) {
            Integer nInteger = nums.get(i);
            // if(nInteger > n){continue;}
            Integer remain = n - nInteger;
            List<Integer> result = bestSumMemo(remain, nums, memo);
            if (result != null) {
                result.add(nInteger);
                try{
                    shortest = result.size() < shortest.size() ? result : shortest;
                }catch(NullPointerException e){
                    shortest = result;
                }
            }
        }
        memo.put(n, shortest);
        return shortest;
    }
}
