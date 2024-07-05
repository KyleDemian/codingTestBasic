package ColumbusStudy.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question4 {

    // https://www.acmicpc.net/problem/7579
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] active = new int[N];
        int[] deActive = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            active[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deActive[i] = Integer.parseInt(st.nextToken());
        }

        // 총 60분이 주어진다고 하면
        // i 번째 앱에 대한 비용 j로 확보 가능한 최대 메모리 ( 앱 최대 100개, 비용은 각각 최대 100 )
        int[][] dp = new int[N][10001];
        int answer = Integer.MAX_VALUE;

        // 5 60
        // 30 10 20 35 40
        // 3  0  3  5  4
        for (int i = 0; i < N; i++) {
            int memory = active[i];
            int cost = deActive[i];
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {   // 0번째 앱은 j >= cost만 확인한다!
                    if(j >= cost) dp[i][j] = memory;
                } else {
                    if( j >= cost){
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                if (dp[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }

        System.out.print(answer);
    }
}
