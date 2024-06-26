package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2 {

    // https://www.acmicpc.net/problem/14620
    // 복습 완
    static int N, answer = Integer.MAX_VALUE;
    static int[][] grape;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grape = new int[N + 1][N + 1];
        ch = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);

        System.out.print(answer);
    }

    static void DFS(int sum, int depth) {
        // 3개의 꽃이 만개한 경우
        if (depth == 3) {
            answer = Math.min(answer, sum);
            return;
        } else {
            // 꽃이 피는걸 계산
            for (int i = 2; i <= (N - 1); i++) {
                for (int j = 2; j <= (N - 1); j++) {
                    if (checked(i, j) && !ch[i][j]) {
                        int cost = grape[i][j];
                        ch[i][j] = true;

                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            ch[nx][ny] = true;
                            cost += grape[nx][ny];
                        }

                        DFS(sum + cost, depth + 1);

                        ch[i][j] = false;
                        for (int k = 0; k < 4; k++) {
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
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 1 || nx > N || ny < 1 || ny > N || ch[nx][ny]) return false;
        }
        return true;
    }

}
