package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10 {

    // https://www.acmicpc.net/problem/9465
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            // 위쪽 또는 아래쪽 스티커를 뗄 경우,
            // 이전 타일에서는 현재 뗀 스티커와 같은 열에 위치한 스티커를 뗄 수 없기 때문에
            // 이전까지의 최대 점수는 dp[상대편 열][i-1]입니다.
            // 현재 타일을 건너뛰는 경우 최대 점수는 dp[0][i-1]과 dp[1][i-1] 중의 최대값과 같습니다.
            // 따라서, dp[j][i] = max(dp[1-j][i-1], dp[0][i-2], dp[1][i-2]) + sticker[j][i]
            for (int i = 2; i <= n; i++) {  // 이 부분이 열
                for (int j = 0; j < 2; j++) { // 이 부분이 행
                    // 1 번 값보다, 2번 값이 컷을경우. // 1번 값의 경우 이전 값,
                    dp[j][i] = Math.max(dp[1-j][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + sticker[j][i];
                }
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
