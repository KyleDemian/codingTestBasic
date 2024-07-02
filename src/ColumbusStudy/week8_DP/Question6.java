package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question6 {

    // https://www.acmicpc.net/problem/1463
    // https://bada744.tistory.com/61
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 3로 나누어 떨어지면 3으로 나누고
        // 2로 나누어 떨어지면 2로 나누고
        // 1을 뺀다.

        // Bottom-Up 방식
        dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  // i에서 1을 뺐을 때의 연산 수를 초기 값으로 설정
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);  // i가 2로 나눠질 때의 연산 수를 계산하여 비교 후 갱신
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);  // i가 3으로 나눠질 때의 연산 수를 계산하여 비교 후 갱신
        }
        System.out.println(dp[n]);
    }
}
