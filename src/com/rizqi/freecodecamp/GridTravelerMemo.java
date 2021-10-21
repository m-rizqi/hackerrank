package com.rizqi.freecodecamp;

import java.util.HashMap;
import java.util.Map;

public class GridTravelerMemo {
    public static void main(String[] args) {
        // no memo
        // System.out.println(gridTravelerNoMemo(1, 1));
        // System.out.println(gridTravelerNoMemo(2, 3));
        // System.out.println(gridTravelerNoMemo(3, 2));
        // System.out.println(gridTravelerNoMemo(3, 3));
        // System.out.println(gridTravelerNoMemo(18, 18));

        // with memo
        Map<String, Long> memo = new HashMap<>();
        System.out.println(gridTravelerMemo(1L, 1L,memo));
        System.out.println(gridTravelerMemo(2L, 3L,memo));
        System.out.println(gridTravelerMemo(3L, 2L,memo));
        System.out.println(gridTravelerMemo(3L, 3L,memo));
        System.out.println(gridTravelerMemo(18L, 18L, memo));
        
    }
    static Integer gridTravelerNoMemo(int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }
        if(n==1 && m == 1){
            return 1;
        }
        return (gridTravelerNoMemo(n-1, m) + gridTravelerNoMemo(n, m-1));
    }
    
    static Long gridTravelerMemo(Long n, Long m, Map<String, Long> memo) {
        String key = n+","+m;
        String key2 = m+","+n;
        if(memo.keySet().contains(key)){
            return memo.get(key);
        }
        if (memo.keySet().contains(key2)) {
            return memo.get(key2);
        }
        if (n == 0L || m == 0L) {
            return 0L;
        }
        if (n == 1L && m == 1L) {
            return 1L;
        }
        memo.put(key,(gridTravelerMemo(n - 1, m, memo) + gridTravelerMemo(n, m - 1, memo)));
        return memo.get(key);
    }
}
