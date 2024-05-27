package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question9 {

    // https://www.acmicpc.net/problem/11726

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int [n + 5];

        dp[0] = 0; // 2 * 0 -> 0 개
        dp[1] = 1; // 2 * 1 -> 1 개
        dp[2] = 2; // 2 * 2 -> 2 개
        dp[3] = 3; // 2 * 3 -> 3 개
        dp[4] = 5; // 2 * 4 -> 5 개

        for (int i = 5; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);

    }
}
