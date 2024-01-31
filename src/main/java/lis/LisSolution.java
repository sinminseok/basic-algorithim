package lis;

import java.util.Arrays;
import java.util.Scanner;

public class LisSolution {
    public static void main(String[] args) {
        int answer = Integer.MIN_VALUE;
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[n];
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = kb.nextInt();
        }

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(numbers[i] > numbers[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            System.out.println(max);
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(answer);
    }


}
