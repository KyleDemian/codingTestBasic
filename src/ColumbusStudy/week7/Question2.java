package ColumbusStudy.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question2 {

    // https://www.acmicpc.net/problem/14620

    static int n, answer = Integer.MAX_VALUE;
    static int[][] grape;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grape = new int[n + 1][n + 1];
        ch = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= n; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        // 오름차순
        System.out.println(answer);
    }

    static void dfs(int sum, int depth){
        if(depth == 3){
            answer = Math.min(answer, sum);
            return;
        } else {
            // 1,1 -> 2,2 부터 + 를 만들 수있어서 수를 줄이기 위해 2,2 부터 하고, 어차피 마지막 행열은 못만듦
            for(int i = 2; i <= n - 1; i++){
                for (int j = 2; j <= n - 1 ; j++) {
                    if (!ch[i][j] && checked(i, j)) {
                        ch[i][j] = true;
                        int cost = grape[i][j];
                        for(int k = 0; k < 4; k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            ch[nx][ny] = true;
                            cost += grape[nx][ny];
                        }
                        dfs(sum+cost, depth+1);
                        ch[i][j] = false;
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            ch[nx][ny] = false;
                        }
                    }
                }
            }
        }
    }

    static boolean checked(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( nx < 1 || nx > n || ny < 1 || ny > n || ch[nx][ny]) return false;
        }
        return true;
    }

}
