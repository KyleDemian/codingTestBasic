package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question12 {

    // https://www.acmicpc.net/problem/2146
    // 복습 완
    static int n;
    static int[][] map;
    static int[][] dist;
    static boolean[][] check;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static Queue<int[]> edgeQueue = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬에 1번섬 2번섬 3번섬 등록.
        int cnt = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 각 섬에 대하여 번호를 부여함
                if(map[i][j] == 1 && !check[i][j]) {
                    bfsIsland(i, j, cnt);
                    cnt++;
                }
            }
        }

        // 각 섬의 가장자리에서부터 다른 섬까지의 거리 측정 시작
//        int result = Integer.MIN_VALUE;   // 가장 큰 값을 구할때
        int result = Integer.MAX_VALUE;     // 가장 거리가 짧은 값을 구할때
        // 가장자리 모든 값이 저장되어서 해당 큐를 돌리면 됌,
        while(!edgeQueue.isEmpty()) {
            int[] cur = edgeQueue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y];
                        dist[nx][ny] = dist[x][y] + 1;
                        edgeQueue.offer(new int[]{nx, ny});
                    }
                    else if(map[nx][ny] != map[x][y]) {
                        result = Math.min(result, dist[nx][ny] + dist[x][y]);
                    }
                }
            }
        }

        // 가장 큰 값
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result = Math.max(result, dist[i][j]);
            }
        }

        System.out.println(result);
    }

    // 1번섬 2번섬 3번섬을 만드는 BFS
    static void bfsIsland(int x, int y, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        map[x][y] = cnt;
        check[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] == 1 && !check[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        check[nx][ny] = true;
                        map[nx][ny] = cnt;
                    } else if(map[nx][ny] == 0 && !check[nx][ny]) {
                        // 섬의 가장자리를 찾은 경우 edge 큐에 저장
                        edgeQueue.offer(new int[]{cur[0], cur[1]});
                    }
                }
            }
        }
    }
}