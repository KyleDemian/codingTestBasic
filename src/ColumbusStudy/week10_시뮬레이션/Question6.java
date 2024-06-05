package ColumbusStudy.week10_시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question6 {
    // https://www.acmicpc.net/problem/16236

    static int N;
    static int shark = 2, cnt = 0, eatCount = 0;   // 초기값
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};  // 상하좌우
    static int[][] grape, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grape = new int[N][N];
        ch = new int[N][N];
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
                if(grape[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }

        BFS(x, y);

        System.out.print(cnt);
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        ch[x][y] = 1;

        while (!q.isEmpty()) {
            int[] qp = q.poll();
            int curX = qp[0];
            int curY = qp[1];

            for(int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];

                // 넘어가면 outOfRange, 작거나 같을때만 먹을 수 잇음
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && grape[nx][ny] <= shark && ch[nx][ny] == 0) {
                    ch[nx][ny] = ch[curX][curY] + 1;

                    if(grape[nx][ny] > 0 && grape[nx][ny] <= shark){
                        grape[nx][ny] = 0;
                        cnt += ch[nx][ny] - 1; // 물고기를 먹어치운 후 이동한 시간을 누적

                        if(++eatCount == shark) {
                            shark++;
                            eatCount = 0;
                        }

                        ch = new int[N][N];
                        q.clear();
                        ch[nx][ny] = 1; // 물고기를 먹은 위치를 방문표시
                        q.offer(new int[]{nx, ny}); // 새로운 위치부터 BFS 시작
                    } else {
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
