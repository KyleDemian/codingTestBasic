package ColumbusStudy.week6_BFS_DFS;

import java.util.*;
import java.io.*;

public class Question10 {
    // https://www.acmicpc.net/problem/2667

    static int n;
    static ArrayList<Integer> list;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] grape, ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ch = new int[n + 1][n + 1];
        grape = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grape[i][j] = line.charAt(j) - '0';
            }
        }

        list = new ArrayList<>();
        // 내가 틀린부분은 이부분 -> 처음에 이부분을 while 안에다가 넣었는데
        // 바깥에서 처리 했어야 했었음.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 체크하지 않은 집만 BFS 호출
                if (ch[i][j] == 0 && grape[i][j] == 1) {
                    list.add(BFS(i, j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        list.stream().forEach(x -> System.out.println(x));
    }

    static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        ch[x][y] = 1;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] == 0 && grape[nx][ny] == 1) {
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
