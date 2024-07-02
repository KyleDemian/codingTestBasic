package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question13 {

    // https://www.acmicpc.net/problem/7562

    static int n, l;
    static int[][] ch;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}
               , dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            // 한 변의 길이
            l = Integer.parseInt(br.readLine());

            ch = new int[l][l];
            // 시작 위치
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()),
                startY = Integer.parseInt(st.nextToken());

            // 도착 지점
            st = new StringTokenizer(br.readLine());
            int destinyX = Integer.parseInt(st.nextToken()),
                destinyY = Integer.parseInt(st.nextToken());

            sb.append(BFS(startX, startY, destinyX, destinyY)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int BFS(int startX, int startY, int destinyX, int destinyY) {
        int L = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});

        ch[startX][startY] = 1;
        while(!q.isEmpty()) {
            int len = q.size();

            for(int i = 0; i < len; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if(x == destinyX && y == destinyY) { return L;}

                for(int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(nx >= 0 && nx < l && ny >= 0 && ny < l && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }

            L++;
        }
        return L;
    }
}
