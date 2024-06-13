package ColumbusStudy.week11_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question10 {

    // https://www.acmicpc.net/problem/1743

    static int N, M, K;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] grape, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grape = new int[N+1][M+1];
        ch = new int[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            grape[x][y] = 1;
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(grape[i][j] == 1) {
                    cnt = BFS(i, j);
                    answer = Math.max(answer, cnt);
                }
            }
        }

        System.out.println(answer);
    }

    static int BFS(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        ch[i][j] = 1;
        int result = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx > 0  && nx <= N && ny > 0 && ny <= M && grape[nx][ny] == 1 && ch[nx][ny] == 0){
                    result++;
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return result;
    }
}
