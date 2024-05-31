package ColumbusStudy.week9_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question12 {

    // https://www.acmicpc.net/problem/1941
    // DFS // BFS 를 섞은 문제.. 개빡쌔네.. 이해하는데 오래걸리네
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static int[][] selected;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        visited = new boolean[25][25];
        // 7 -> 학생의 수
        // 학생의 위치 표시
        selected = new int[7][2];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        DFS(0, 0, 0);
        System.out.println(result);
    }

    static void DFS(int idx, int cnt, int s) {
        if (cnt == 7) {
            if (s >= 4 && isConnected()) result++;
            return;
        }

        for (int i = idx; i < 25; i++) {
            // i 0 x 0 y 0
            // i 1 x 0 y 1
            // i 2 x 0 y 2
            int x = i / 5;  // 행값
            int y = i % 5;  // 열값

            if (!visited[x][y]) {
                visited[x][y] = true;
                selected[cnt] = new int[]{x, y};
                DFS(i + 1, cnt + 1, s + (map[x][y] == 'S' ? 1 : 0));
                visited[x][y] = false;
            }
        }
    }

    static boolean isConnected() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[5][5];
        q.add(selected[0]);
        check[selected[0][0]][selected[0][1]] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if (!check[nx][ny] && visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        check[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count == 7;
    }
}
