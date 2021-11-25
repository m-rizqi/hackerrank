package hackerrank.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BestDivisor {
    static ArrayList<Integer> primes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> factors = new ArrayList<>();
        int divider = 1;
        for (int i = 0; i <= n/2; i++) {
            int remainder = n%divider;
            int quotient = n/divider;
            if(remainder == 0){
                if(!factors.contains(quotient) && !factors.contains(divider)){
                    factors.add(quotient);
                    factors.add(divider);
                }
            }
            divider++;
        }
        factors.stream().sorted();
        int numbers = factors.get(0);
        for (int i = 1; i < factors.size(); i++) {
            if(sum(factors.get(i)) > sum(numbers)){
                numbers = factors.get(i);
            }else if (sum(factors.get(i)) == sum(numbers)) {
                numbers = factors.get(i) < numbers ? factors.get(i) : numbers;
            }
        }
        System.out.println(numbers);
    }
    static int sum(int n){
        String s = String.valueOf(n);
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += Integer.parseInt(s.substring(i,i+1));
        }
        return total;
    }    
}
