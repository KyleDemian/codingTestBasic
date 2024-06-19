package ColumbusStudy.week6_BFS_DFS;

import java.util.*;
import java.io.*;

public class Question6 {
    // https://www.acmicpc.net/problem/7576
    // 복습 완
    static int N, M;
    static int[][] grape, ch;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grape = new int[N][M];
        ch = new int[N][M];

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                grape[i][j] = Integer.parseInt(st.nextToken());
                if(grape[i][j] == 1) q.offer(new Point(i, j));
            }
        }

        BFS();

        boolean flag = false;
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grape[i][j] == 0) flag = true;
            }
        }

        if(!flag){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    answer = Math.max(answer, ch[i][j]);
                }
            }
            System.out.print(answer);
        } else System.out.print(-1);
    }

    static void BFS(){
        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && grape[nx][ny] == 0){
                    grape[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    ch[nx][ny] = ch[x][y] + 1;
                }
            }
        }
    }

    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
