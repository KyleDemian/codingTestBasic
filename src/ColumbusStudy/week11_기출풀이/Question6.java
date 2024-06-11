package ColumbusStudy.week11_기출풀이;

import ColumbusStudy.week10_시뮬레이션.Question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question6 {

    // https://www.acmicpc.net/problem/16234

    static int N, L, R;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int[][] grape, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grape = new int[N][N];
        ch = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        boolean isMoved = true;
        while(isMoved){
            isMoved = false;
            cnt++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (ch[i][j] != cnt) {
                        if(BFS (i, j, cnt)) isMoved = true;
                    }
                }
            }
        }

        System.out.println(cnt - 1);
    }

    static boolean BFS(int x, int y, int cnt) {
        Queue<Point> q = new LinkedList<>();    // 국가를 탐색하기 위해 위치를 저장
        List<Point> list = new ArrayList<>();   // 연합된 국가들을 저장
        q.offer(new Point(x, y));
        list.add(new Point(x, y));

        ch[x][y] = cnt;
        int num = grape[x][y];

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && ch[nx][ny] != cnt) {
                    int diff = Math.abs(grape[p.x][p.y] - grape[nx][ny]);
                    if (L <= diff && diff <= R) {
                        ch[nx][ny] = cnt;
                        num += grape[nx][ny];
                        q.offer(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                    }
                }
            }
        }

        for(Point ob: list){
            grape[ob.x][ob.y] = num / list.size();
        }
        if(list.size() == 1) return false;
        return true;
    }

    static class Point {
        int x , y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
