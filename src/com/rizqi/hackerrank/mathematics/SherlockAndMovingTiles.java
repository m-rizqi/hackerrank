package com.rizqi.hackerrank.mathematics;

import java.io.*;

import java.util.Scanner;

public class SherlockAndMovingTiles {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Long l = sc.nextLong();
        Long v1 = sc.nextLong();
        Long v2 = sc.nextLong();
        Long n = sc.nextLong();
        for (int i = 0; i < n; i++) {
            Long q = sc.nextLong();
            Double h = l.doubleValue() - Math.sqrt(q);
            Double r = Math.abs(v1 - v2) / Math.sqrt(2);
            Double t = h/r;
            System.out.printf("%.10f\n",t);
        }
    }
}
