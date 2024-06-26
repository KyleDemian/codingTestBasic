package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question8 {

    // https://www.acmicpc.net/problem/2206
    // 복습 완료
    static int n, m;
    static int[][] grape;
    static int[][][] ch;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grape = new int[n + 1][m + 1];
        ch = new int[n + 1][m + 1][2];  // 0 - 일때는 사용 가능, 1일때는 사용 불가능

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                grape[i][j] = line.charAt(j - 1) - '0';
            }
        }

        System.out.println(BFS());
    }

    static int BFS(){
        q = new LinkedList<>();
        q.offer(new int[]{1, 1, 1, 0}); // depth = 1, cnt = 0부터 시작
        ch[1][1][0] = 1; // 시작 지점의 최소 단계 수 저장 (cnt=0)

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int wall = cur[3];

            if(x == n && y == m){ return count;}

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
                    // 1회 사용
                    if (grape[nx][ny] == 1 && wall == 0) {
                        // 벽이 있는 위치고, 벽을 아직 부수지 않았다면
                        q.offer(new int[]{nx, ny, count + 1, wall + 1});
                        ch[nx][ny][wall + 1] = ch[x][y][wall] + 1;
                    } else if (grape[nx][ny] == 0 && ch[nx][ny][wall] == 0) {
                        // 벽이 없는 위치로 이동하고 아직 방문하지 않았다면
                        q.offer(new int[]{nx, ny, count + 1, wall});
                        ch[nx][ny][wall] = ch[x][y][wall] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
