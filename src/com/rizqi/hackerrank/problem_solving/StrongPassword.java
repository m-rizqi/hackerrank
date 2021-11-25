package hackerrank.problem_solving;

import java.util.Scanner;

public class StrongPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        String s = sc.next();
        int n = 6 - l;
        int r = 0;
        boolean num = false, 
            low = false, 
            up = false, 
            sp = false;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(num == false && a >= 48 && a <= 57){
                num = true;
                r++;
            }
            if (low == false && a >= 97 && a <= 122) {
                low = true;
                r++;
            }
            if (up == false && a >= 65 && a <= 90) {
                up = true;
                r++;
            }
            if (sp == false) {
                String special = "!@#$%^&*()-+";
                if(special.contains(String.valueOf(a))){
                    sp = true;
                    r++;
                }
            }
        }
        r = 4 - r;
        System.out.println(Math.max(r, n));
    }
}
