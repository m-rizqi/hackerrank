package hackerrank.problem_solving;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TwoCharacters {
    static boolean isAlt(int[] str){
        return str[0] != str[1] && IntStream.range(2, str.length).allMatch(i->str[i]==str[i%2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        String s = sc.next();
        int[] nums = s.chars().distinct().toArray();
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int a = nums[i], b = nums[j];
                int[] removed = s.chars().filter(c->c==a || c==b).toArray();
                if (isAlt(removed) && removed.length > maxLength)
                    maxLength = removed.length;
            }
        }
        System.out.println(maxLength);
    }
    
}
