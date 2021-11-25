package hackerrank.problem_solving;

import java.util.Scanner;

public class FlatlandSpaceStations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] c = new int[m];
        for (int i = 0; i < c.length; i++) {
            c[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int min = n;
            for (int j = 0; j < c.length; j++) {
                min = Math.min(min, Math.abs((i - c[j])));
            }
            max = min > max ? min : max;
        }
        System.out.println(max);
    }
}
