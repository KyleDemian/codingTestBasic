package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Question7 {

    // https://www.acmicpc.net/problem/2839
    // https://st-lab.tistory.com/72
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] weights = {3, 5};

        for (int i=0; i<2; i++) {
            for (int j=weights[i]; j<=N; j++) {
                dp[j] = Math.min(dp[j], dp[j-weights[i]] != Integer.MAX_VALUE ?
                        dp[j-weights[i]] + 1 : Integer.MAX_VALUE);
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}
