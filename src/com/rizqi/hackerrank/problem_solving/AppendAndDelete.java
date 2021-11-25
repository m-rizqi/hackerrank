package hackerrank.problem_solving;

import java.util.Scanner;

public class AppendAndDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int k = sc.nextInt();
        int i = 0;
        while (i < Math.min(s.length(), t.length())) {
            if(s.charAt(i) == t.charAt(i)){
                i++;
            }else{
                break;
            }
        }
        if(s.length()+t.length() -2*i > k){
            System.out.println("No");
        }else if((s.length()+t.length() -2*i)%2==k%2){
            System.out.println("Yes");
        }else if(s.length() + t.length() - k < 0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
