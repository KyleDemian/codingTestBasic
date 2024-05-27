package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question11 {
    // https://www.acmicpc.net/problem/1743
    // 이전에 풀었던 문제랑 동일한 문제

    static int n, m, k;
    static int[][] grape, ch;
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grape = new int[n+1][m+1];
        ch = new int[n+1][m+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 쓰레기 값만 체크
            grape[a][b] = 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grape[i][j] != 0) {
                    max = Math.max(max, BFS(i, j));
                }
            }
        }
        System.out.println(max);
    }

    static int BFS(int x, int y) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        ch[x][y] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];

            result++;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= m && grape[nx][ny] == 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return result;
    }
}
