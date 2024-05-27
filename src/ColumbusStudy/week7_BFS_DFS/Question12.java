package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question12 {

    // https://www.acmicpc.net/problem/2146
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
        int result = Integer.MAX_VALUE;
        // 가장자리 모든 값이 저장되어서 해당 큐를 돌리면 됌,
        while(!edgeQueue.isEmpty()) {
            int[] cur = edgeQueue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = map[cur[0]][cur[1]];
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        edgeQueue.offer(new int[]{nx, ny});
                    }
                    else if(map[nx][ny] != map[cur[0]][cur[1]]) {
                        // 다른 섬에 도달했을 경우 그때의 거리를 결과 값으로 사용
                        // dist[cur[0]][cur[1]]는 현재 위치까지 다리를 만드는 데 필요한 최소 거리를 나타냅니다.
                        // dist[nx][ny]는 이전 위치에서 현재 위치까지의 거리를 나타냅니다.
                        // 이 두 거리를 합한 값이 현재 섬에서 다른 섬까지 다리를 만드는 데 필요한 총 거리가 됩니다.
                        // dist[nx][ny] + dist[cur[0]][cur[1]]는 현재 섬에서 다른 섬까지 다리를 만들 때의 최소 거리를 나타내는 것입니다.
                        // 그런 후 Math.min(result, dist[nx][ny] + dist[cur[0]][cur[1]])를 통해 이 거리가
                        // 이전에 구한 최소 거리보다 작은지 확인하고, 만약 더 작다면 최소 거리를 갱신합니다.
                        result = Math.min(result, dist[nx][ny] + dist[cur[0]][cur[1]]);
                    }
                }
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
                    }
                    else if(map[nx][ny] == 0 && !check[nx][ny]) {
                        // 섬의 가장자리를 찾은 경우 edge 큐에 저장
                        edgeQueue.offer(new int[]{cur[0], cur[1]});
                    }
                }
            }
        }
    }
}