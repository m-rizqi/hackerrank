package com.rizqi.hackerrank.mathematics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            if(c < r){
                int temp = r;
                r = c;
                c = temp;
            }
            List<Integer> rF = getFactors(r);
            List<Integer> cF = getFactors(c);
            int largest = 0;
            for (Integer integer : rF) {
                if(cF.contains(integer)){
                    largest = integer > largest ? integer : largest;
                }
            }
            System.out.println((r/largest)*(c/largest));  
        }          
    }
    static List<Integer> getFactors(int n){
        List<Integer> factors = new ArrayList<>();
        int divider = 1;
        for (int i = 0; i <= n/2; i++) {
            int quotient = n/divider;
            int remainder = n%divider;
            if(remainder == 0){
                if(!(factors.contains(quotient) || factors.contains(divider))){
                    factors.add(quotient);
                    factors.add(divider);
                }
            }
            divider++;
        }
        return factors;
    }
}
