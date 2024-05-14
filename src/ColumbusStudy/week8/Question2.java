package ColumbusStudy.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2 {

    // https://www.acmicpc.net/problem/1010
    // https://st-lab.tistory.com/194

    // IDE 에서 출력이 왜 제대로 안뜨찌..?
    static int T, n, m;
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // M개중 N개를 뽑는 경우이므로 nCr 에서 x = M, y = N이다.
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(recursive(m, n)).append('\n');
        }

        System.out.println(sb.toString());
    }

    static int recursive(int x, int y){
        if(dp[x][y] > 0) return dp[x][y];
        if (x == y || y == 0) return dp[x][y] = 1;
        return dp[x][y] = recursive(x -1, y-1) + recursive(x-1, y);
    }
}
