package ColumbusStudy.week12_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question10 {

    // https://www.acmicpc.net/problem/15558

    static int n, k;
    static int[][] grape, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 0 왼쪽, 1 오른쪽
        grape = new int[2][n];
        ch = new int[2][n];

        // grape[0][0] 항상 안전한 칸
        for(int i = 0; i < 2; i++){
            String line = br.readLine();
            for(int j = 0; j < n ; j++){
                grape[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.print(BFS());
    }

    static int BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 0 });
        ch[0][0] = 1;

        int[] dy = { 1, -1, k, -k, 0 };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int direction = cur[0];
            int y = cur[1];
            int time = cur[2];

            for (int i = 0; i < 5; i++) {
                int nx = direction;
                int ny = y + dy[i];
                if (i == 2 || i == 3) {
                    nx = 1 - direction; // Switch lanes
                }

                if (ny >= n) return 1; // Cleared the game

                if (ny < 0 || grape[nx][ny] == 0 || ch[nx][ny] == 1) continue;
                if (ny <= time) continue;

                ch[nx][ny] = 1;
                q.offer(new int[] { nx, ny, time + 1 });
            }
        }

        return 0;
    }
}
