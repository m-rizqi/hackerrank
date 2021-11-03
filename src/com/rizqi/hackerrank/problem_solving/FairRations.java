package com.rizqi.hackerrank.problem_solving;

import java.util.Scanner;

public class FairRations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] B = new int[n];
        for (int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        }
        int l = 0;
        for (int i = 0; i < B.length-1; i++) {
            if(B[i]%2!=0){
                B[i]++;
                B[i+1]++;
                l += 2;
            }
        }
        System.out.println(B[B.length-1]%2==0 ? String.valueOf(l) : "NO");       
    }
}
