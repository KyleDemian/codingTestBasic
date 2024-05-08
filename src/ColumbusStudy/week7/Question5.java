package ColumbusStudy.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question5 {

    // https://www.acmicpc.net/problem/1600
    static int k, h, w;
    static int[][] grape;
    static int[][][] visit;
    static Queue<int[]> q = new LinkedList<>();
//    static int[] hx = {2, 1, -1, -2, -2, -1, 1, 2};
//    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[] dx = {1, 0, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2},
            dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        grape = new int[h][w];
        visit = new int[h][w][31];

        for (int i = 0; i < h; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        q.offer(new int[]{0, 0, 0, k});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int z = cur[3];

            if (x == h - 1 && y == w - 1) {
                return cnt;
            }

            for (int i = 0; i < 12; i++) {
                int nhx = x + dx[i];
                int nhy = y + dy[i];

                if(nhx < 0 || nhx >= h || nhy < 0 || nhy >= w || grape[nhx][nhy] == 1) continue;

                if( i < 4 ){
                    // 원숭이 움직임
                    if ( visit[nhx][nhy][z] == 0 ) {
                        q.offer(new int[] {nhx, nhy, cnt + 1, z});
                        visit[nhx][nhy][z] = 1;
                    }
                } else {
                    // 말 움직임
                    if (z > 0 && visit[nhx][nhy][z - 1] == 0) {
                        q.offer(new int[] {nhx, nhy, cnt + 1, z - 1});
                        visit[nhx][nhy][z - 1] = 1;
                    }
                }
            }
        }
        return -1;
    }

//    static void BFS() {
//        // 시작 위치
//        q.offer(new int[]{0, 0});
//
//        while (!q.isEmpty()) {
//            int len = q.size();
//
//            for (int i = 0; i < len; i++) {
//                int[] cur = q.poll();
//                int x = cur[0];
//                int y = cur[1];
//
//                int nhx = x;
//                int nhy = y;
//                if (k > 0) {
//                    for (int j = 0; j < 7; j++) {
//                        nhx = x + hx[j];
//                        nhy = y + hy[j];
//
//                        if(nhx >= 0 && nhx < h && nhy >= 0 && nhy < w && grape[nhx][nhy] != 1 && ch[nhx][nhy] == 0){
//                            q.offer(new int[]{nhx, nhy});
//                            ch[nhx][nhy] = ch[x][y] + 1;
//                        }
//                    }
//                    k--;
//                }
//
//                for (int j = 0; j < 4; j++) {
//                    int nx = nhx + dx[j];
//                    int ny = nhy + dy[j];
//
//                    if(nx >= 0 && nx < h && ny >= 0 && ny < w && grape[nx][ny] != 1 && ch[nx][ny] == 0){
//                        q.offer(new int[]{nx, ny});
//                        ch[nx][ny] = ch[x][y] + 1;
//                    }
//                }
//            }
//        }
//    }
}
