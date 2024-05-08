package ColumbusStudy.week6;

import java.io.*;
import java.util.*;

public class Question9 {
    // https://www.acmicpc.net/problem/2178

    static int n, m, cnt;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] grape;
    static int[][] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ch = new int[n + 1][m + 1];
        grape = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                grape[i+1][j+1] = line.charAt(j) - '0';
            }
        }

        // 1, 1 부터 출발 해서
        BFS(1, 1, 1);

        System.out.println(cnt);
    }

    static void BFS(int L, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, x, y});
        ch[1][1] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            L = cur[0];
            x = cur[1];
            y = cur[2];

            if(x == n && y == m){cnt = L; return;}

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= m && ch[nx][ny] != 1 && grape[nx][ny] == 1){
                    ch[nx][ny] = 1;
                    q.offer(new int[]{L+1, nx, ny});
                }
            }
        }
    }
}
