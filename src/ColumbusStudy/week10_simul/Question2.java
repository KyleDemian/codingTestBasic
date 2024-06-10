package ColumbusStudy.week10_simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question2 {

    // https://www.acmicpc.net/problem/16234
    // 2회차 복습 완
    static int N, L, R;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int[][] grape;
    static int[][] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grape = new int[N][N];
        ch = new int[N][N]; // 나라마다 할당되는 연합 번호  // 최초에는 각자 인덱스 번호

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; // 연합의 번호
        boolean isMoved = true; // 인구 이동 여부
        while (isMoved) {
            isMoved = false;
            cnt++;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (ch[i][j] != cnt) {  // 아무것도 방문하지 않은 최초의 나라
                        // 즉, 최초에는 0,0 -> 그 나라는 1번이 됌
                        if (BFS(i, j, cnt)) isMoved = true;
                    }
                }
            }
        }
        System.out.println(cnt - 1);
    }

    static boolean BFS(int x, int y, int cnt) {
        Queue<Point> q = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        q.offer(new Point(x, y));
        list.add(new Point(x, y));
        ch[x][y] = cnt; // 지금 연합의 번호를 할당
        int pNum = grape[x][y];

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && ch[nx][ny] != cnt) {
                    int peopleDiff = Math.abs(grape[p.x][p.y] - grape[nx][ny]);
                    if (L <= peopleDiff && peopleDiff <= R) {
                        ch[nx][ny] = cnt;
                        pNum += grape[nx][ny];
                        q.add(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                    }
                }
            }
        }
        // 연합국들끼리 인구 이동
        for (Point u : list) grape[u.x][u.y] = pNum / list.size();
        if (list.size() == 1) return false;
        return true;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
