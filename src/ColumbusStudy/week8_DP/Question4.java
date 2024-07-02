package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question4 {

    // https://www.acmicpc.net/problem/11727
    // 복습 완료
    static int n;
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp[1] = 1;  // 2 * 1 -> 1개 블럭만
        dp[2] = 3;  // 2 * 2 -> 가로*2 세로*2 2*2 총 3개
        dp[3] = 5;  // 2 * 3 -> 5개 i-2 *2 + i-1 => 5
        dp[4] = 11;  // 2 * 4 -> 11개 i-2 *2 + i-1 => 11

        for(int i = 5; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
