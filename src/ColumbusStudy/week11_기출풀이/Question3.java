package ColumbusStudy.week11_기출풀이;

import java.io.*;
import java.util.*;

public class Question3 {

    // https://www.acmicpc.net/problem/4485
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] grape, ch;
    static int result, N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            cnt++;
            result = Integer.MAX_VALUE;

            grape = new int[N][N];
            ch = new int[N][N];

            // 각 배열 삽입
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    grape[i][j] = Integer.parseInt(st.nextToken());
                    ch[i][j] = Integer.MAX_VALUE;
                }
            }

            Dijkstra(0, 0);

            sb.append("Problem ").append(cnt).append(": ").append(ch[N-1][N-1]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void Dijkstra(int row, int col) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ch[row][col] = grape[row][col];
        pq.offer(new Edge(row, col, ch[row][col]));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int x = e.x;
            int y = e.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(ch[nx][ny] > ch[x][y] + grape[nx][ny]){
                        ch[nx][ny] = ch[x][y] + grape[nx][ny];
                        pq.offer(new Edge(nx, ny, ch[nx][ny]));
                    }
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int x, y, cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }
}
