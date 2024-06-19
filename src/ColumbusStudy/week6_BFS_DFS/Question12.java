package ColumbusStudy.week6_BFS_DFS;

import java.io.*;
import java.util.*;

public class Question12 {

    // https://www.acmicpc.net/problem/14940
    // 복습 완료
    static int N, M;
    static int[][] ch, grape;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grape = new int[N][M];
        ch = new int[N][M];

        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(ch[i], -1);
            for (int j = 0; j < M; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
                if (grape[i][j] == 2) {
                    x = i;
                    y = j;
                } else if (grape[i][j] == 0) {
                    ch[i][j] = 0;
                }
            }
        }

        BFS(x, y);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ch[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        ch[i][j] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && grape[nx][ny] == 1 && ch[nx][ny] == -1) {
                    ch[nx][ny] = ch[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
