package ColumbusStudy.week6_BFS_DFS;

import java.io.*;
import java.util.*;

public class Question9 {
    // https://www.acmicpc.net/problem/2178
    // 복습 완
    static int N, M;
    static int[][] grape, ch;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grape = new int[N+1][M+1];
        ch = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                grape[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
            }
        }

        BFS(1, 1);

        System.out.print(cnt);
    }

    static void BFS(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, 1});
        ch[i][j] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            if(x == N && y == M) {cnt = cost; return;}

            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if( nx > 0 && nx <= N && ny > 0 && ny <= M && grape[nx][ny] == 1 && ch[nx][ny] == 0){
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny, cost+1});
                }
            }
        }
    }
}
