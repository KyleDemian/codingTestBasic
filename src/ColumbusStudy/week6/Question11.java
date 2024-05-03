package ColumbusStudy.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11 {
    // https://www.acmicpc.net/problem/14502
    // 수치가 작기때문에 인접 행렬로 하면 될거같음. DFS로 접근해야하지 않을까?

    static int n, m;
    static int answer = 0;
    static int[][] ch, grape;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grape = new int[n][m];
        ch = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                grape[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0);

        System.out.println(answer);
    }

    static void DFS(int x, int y, int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < n; i++)
                System.arraycopy(grape[i], 0, ch[i], 0, m);

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (ch[i][j] == 2) spreadVirus(i, j);

            answer = Math.max(answer, getSafeArea());
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                if (grape[i][j] != 0) continue;
                grape[i][j] = 1;
                DFS(i, j, cnt + 1);
                grape[i][j] = 0;
            }
            y = 0;
        }
    }

    static void spreadVirus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (ch[nx][ny] == 0) {
                    ch[nx][ny] = 2;
                    spreadVirus(nx, ny);
                }
            }
        }
    }

    static int getSafeArea() {
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 0) ++safeArea;
            }
        }
        return safeArea;
    }

//    static void DFS(int block) {
//        if (block == 3) {
//            for(int i = 0; i < n; i++) {
//                for(int j = 0; j < m; j++) {
//                    if(grape[i][j] == 0) {
//                        cnt++;
//                    }
//                }
//            }
//            answer = Math.max(answer, cnt);
//        } else {
//            // 전체 탐색을 다해야 할거 같음.
//            for (int k = 0; k < n; k++) {
//                for (int l = 0; l < m; l++) {
//                    for (int i = 0; i < 4; i++) {
//                        int nx = dx[i] + x;
//                        int ny = dy[i] + y;
//
//                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grape[x][y] == 2 && grape[nx][ny] == 0 ){
//                            grape[nx][ny] = 1;
//                            DFS(block + 1);
//                            grape[nx][ny] = 0;
//                        }
//                    }
//
//                }
//            }
//        }
//    }
}
