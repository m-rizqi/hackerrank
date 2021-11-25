package freecodecamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FibMemo {
    public static void main(String[] args) {
        // no memo
        // System.out.println(fibNoMemo(6));
        // System.out.println(fibNoMemo(7));
        // System.out.println(fibNoMemo(8));
        // System.out.println(fibNoMemo(50));

        // with memo
        Map<Long, Long> memo = new HashMap<>();
        System.out.println(fibMemo(6L,memo));
        System.out.println(fibMemo(7L,memo));
        System.out.println(fibMemo(8L,memo));
        System.out.println(fibMemo(50L,memo));
    }
    static long fibNoMemo(long n){
        if(n <= 2)return 1;
        return fibNoMemo(n-1)+fibNoMemo(n-2);
    }
    static Long fibMemo(Long n, Map<Long, Long> memo){
        if(memo.keySet().contains(n)){
            return memo.get(n);
        }
        if(n <= 2){
            return 1L;
        };
        memo.put(n, fibMemo(n-1,memo)+fibMemo(n-2,memo));
        return memo.get(n);
    }
}
