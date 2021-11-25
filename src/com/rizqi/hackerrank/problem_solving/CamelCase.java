package hackerrank.problem_solving;

import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = 1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                n++;
            }
        }
        System.out.println(n);
    }
}
