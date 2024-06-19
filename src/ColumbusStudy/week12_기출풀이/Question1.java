package ColumbusStudy.week12_기출풀이;

import java.io.*;
import java.util.*;

public class Question1 {

    // https://www.acmicpc.net/problem/17836
    static int N, M, T;
    static int[][] grape, ch;
    static int[] dx = {-1, 0, 1, 0} ,dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        grape = new int[N+1][M+1];
        ch = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(ch[i], -1);
            for(int j = 1; j <= M; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 검을 처음부터 들고 있었는지에 대한 가정
        int initialSword = (grape[1][1] == 2) ? 1 : 0;
        BFS(1, 1, initialSword);

        if(ch[N][M] == -1 || ch[N][M] > T) { System.out.print("Fail"); }
        else { System.out.print(ch[N][M]); }
    }

    static void BFS(int x, int y, int sword) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, sword});
        ch[x][y] = 0;

        while(!q.isEmpty()) {
            int[] coo = q.poll();
            int nowX = coo[0];
            int nowY = coo[1];
            int nowSword = coo[2];

            if(ch[nowX][nowY] > T) { break; }

            for(int k = 0; k < 4; k++) {
                int nx = nowX + dx[k];
                int ny = nowY + dy[k];

                if(nx > 0 && nx <= N && ny > 0  && ny <= M){
                    if(nowSword == 1){
                        if (ch[nx][ny] == -1 || ch[nx][ny] > ch[nowX][nowY] + 1) {
                            ch[nx][ny] = ch[nowX][nowY] + 1;
                            q.offer(new int[]{nx, ny, nowSword});
                        }
                    } else {
                        if(ch[nx][ny] == -1){
                            if(grape[nx][ny] == 2){
                                ch[nx][ny] = ch[nowX][nowY] + 1;
                                q.offer(new int[]{nx, ny, nowSword + 1});
                            } else if(grape[nx][ny] == 0) {
                                ch[nx][ny] = ch[nowX][nowY] + 1;
                                q.offer(new int[]{nx, ny, nowSword});
                            }
                        }
                    }
                }
            }
        }
    }
}