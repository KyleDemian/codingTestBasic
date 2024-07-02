package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2 {

    // https://www.acmicpc.net/problem/1010
    // 복습 완
    // https://st-lab.tistory.com/194

    static int T, n, m;
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(recursive(m, n)).append('\n');
        }

        System.out.println(sb);
    }

    static int recursive(int x, int y){
        if(dp[x][y] > 0) return dp[x][y];
        if (x == y || y == 0) return dp[x][y] = 1;
        return dp[x][y] = recursive(x -1, y-1) + recursive(x-1, y);
        // n번째 원소를 선택하는 경우: 이 경우, n-1개의 원소 중에서 r-1개를 더 선택해야 합니다. 따라서 이는 C(n-1, r-1)와 같습니다.
        // n번째 원소를 선택하지 않는 경우: 이 경우, n-1개의 원소 중에서 r개를 선택해야 합니다. 따라서 이는 C(n-1, r)와 같습니다.
    }
}
