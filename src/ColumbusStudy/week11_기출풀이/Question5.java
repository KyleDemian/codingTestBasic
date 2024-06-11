package ColumbusStudy.week11_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question5 {

    // https://www.acmicpc.net/problem/16985

    static int[][][] arr, map;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;

    // 회전하기 위해서 사용하는 축의 방향
    static int[] dz = { -1, 1, 0, 0, 0, 0 };
    static int[] dx = { 0, 0, -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5][5];             // 사용자 배열
        visited = new boolean[5][5][5];     // 방문 확인
        map = new int[5][5][5];             // 결과값 저장

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dfs(0, 0);

        System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

    public static boolean isRange(int z, int x, int y) {
        return 0 <= z && z < 5 && 0 <= x && x < 5 && 0 <= y && y < 5;
    }

    public static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0, 0));
        visited = new boolean[5][5][5];
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.z == 4 && p.x == 4 && p.y == 4)
                return p.count;

            for (int i = 0; i < 6; i++) {
                int nz = p.z + dz[i];
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (isRange(nz, nx, ny) && map[nz][nx][ny] == 1 && !visited[nz][nx][ny]) {
                    q.offer(new Point(nz, nx, ny, p.count + 1));
                    visited[nz][nx][ny] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void dfs(int depth, int visited) {
        if (depth == 5) {
            // 총 깊이 5번의 z 축을 움직이고, 해당 시작, 종료값이 닿을 수 있다면
            if (map[0][0][0] == 1 && map[4][4][4] == 1) {
                int temp = bfs();
                answer = Math.min(answer, temp);
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            // 판의 이동 이제일 이해가 어렵다...
            if ((visited & (1 << i)) == 0) {
                for (int j = 0; j < 4; j++) {
                    rotation(i);
                    map[depth] = arr[i];
                    dfs(depth + 1, visited | (1 << i));
                }
            }
        }
    }

    // 각 판을 회전시키는 함수
    public static void rotation(int idx) {
        int[][] temp = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                temp[i][j] = arr[idx][i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[idx][i][j] = temp[4 - j][i];
            }
        }
    }

    static class Point {
        int x, y, z, count;

        Point(int z, int x, int y, int count) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
