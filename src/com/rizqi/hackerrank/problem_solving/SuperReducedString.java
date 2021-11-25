package hackerrank.problem_solving;

import java.util.Scanner;

public class SuperReducedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = 0, n = s.length()-1;
        while(i<n){
            if(s.charAt(i) == s.charAt(i+1)){
                String a = s.substring(0, i);
                String b = s.substring(i+2);
                s = a+b;
                i = 0;
                n -= 2;
            }else{
                i++;
            }
        }
        System.out.println(s.isEmpty()?"Empty String":s);
    }
}
