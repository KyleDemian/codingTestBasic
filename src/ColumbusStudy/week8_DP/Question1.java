package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1{

    // https://www.acmicpc.net/problem/2748
    // 복습 완
    static long[] dp = new long[91];
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp[0] = 0;

        System.out.print(fibo(N));
    }

    static long fibo(int n){
        if(n == 1 || n == 2) return dp[n] = 1;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fibo(n-2) + fibo(n-1);
    }
}
