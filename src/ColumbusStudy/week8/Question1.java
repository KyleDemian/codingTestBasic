package ColumbusStudy.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1{

    // https://www.acmicpc.net/problem/2748
    static long[] dp = new long[91];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;      // 틀린 이유 초기 설정값 0, 1, 1 순으로
        System.out.println(fibo(n));
    }

    static long fibo(int n) {
        if (n <= 1) return dp[n];
        if(dp[n] != 0) return dp[n];
        dp[n] = fibo(n-1) + fibo(n-2);
        return dp[n];
    }
}
