package hackerrank.problem_solving;

import java.util.Scanner;

public class CaesarChiper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        String s = sc.next();
        int k = sc.nextInt();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i] >= 65 && c[i] <= 90){
                c[i] += k;
                if(c[i] > 90){
                    c[i] -= 26;
                }
            }
            if (c[i] >= 97 && c[i] <= 122) {
                c[i] += k;
                if (c[i] >122) {
                    c[i] -= 26;
                }
            }
        }
        System.out.println(String.valueOf(c));
    }
    
}
