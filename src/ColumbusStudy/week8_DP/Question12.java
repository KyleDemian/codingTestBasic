package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question12 {
    // https://www.acmicpc.net/problem/10844 // 점화식
    // https://jangkunstory.tistory.com/44
    // https://velog.io/@doorbals_512/%EB%B0%B1%EC%A4%80-10844%EB%B2%88-%EC%89%AC%EC%9A%B4-%EA%B3%84%EB%8B%A8

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mod = 1000000000;

        long[][] dp = new long[n + 1][10];

        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 2번째 자리 부터 시작
        for (int i = 2; i <= n; i++) {
            // 0~ 9 까지의 숫자
            for(int j = 0; j < 10; j++) {
                dp[i][j] = 0;
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 < 10) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= mod;
            }
        }

        long anwer = 0;
        for (int i = 0; i <= 9; i++) {
            anwer += dp[n][i];
        }
        anwer %= mod;
        System.out.println(anwer);

        // 1 -> 9
        // 2 -> 17 ( 차이 8 )
        // 3 -> 32 ( 차이 15 )
        // 4 -> 61 ( 차이 29 )
        // 출력예제 -> answer * 2 - i - 1
        // 차이기준 -> 차이 * 2 + i - 1 값
    }
}
