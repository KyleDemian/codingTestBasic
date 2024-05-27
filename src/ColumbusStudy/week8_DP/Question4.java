package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question4 {

    // https://www.acmicpc.net/problem/11727
    static int n;
    static int div = 10007;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 3];

        dp[1] = 1;  // 2 * 1 -> 1개 블럭만
        dp[2] = 3;  // 2 * 2 -> 가로*2 세로*2 2*2 총 3개
        dp[3] = 5;  // 2 * 3 -> 5개 i-2 *2 + i-1 => 5
        dp[4] = 11;  // 2 * 4 -> 11개 i-2 *2 + i-1 => 11

        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % div;
        }

        System.out.println(dp[n]);
        // 모듈러 연산은 (a + b) mod n = ((a mod n) + (b mod n)) mod n과 같은 성질을 가지고 있습니다.
        // 이 성질을 통해 계산 시마다 결과를 10007로 나눈 나머지를 구하여 저장할 수 있습니다.
        // 결론적으로, 10007로 나누는 것은 변수의 오버플로우를 해결하는 동시에 문제 문장에 맞추어 답을 구하는 방법입니다.
    }
}
