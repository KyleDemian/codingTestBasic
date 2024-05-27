package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question3 {

    // https://www.acmicpc.net/problem/5547
    // https://codingrapper.tistory.com/207 다른 사람 풀이

    static int[][] grape = new int[101][101];
    static int[] dx = {0, 0, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, -1, 0, 1};
    static int h, w, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());   // y 좌표
        h = Integer.parseInt(st.nextToken());   // x 좌표

        for(int i = 1; i < h; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 1; j < w; j++) {
                grape[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        for (int i = 0; i <= h + 1; i++) {
            BFS(i, 0);
            BFS(i, w + 1);
        }
        for (int j = 0; j <= w + 1; j++) {
            BFS(0, j);
            BFS(h + 1, j);
        }

        System.out.println(result);
    }

    static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && nx <= h+1 && ny >= 0 && ny <= w+1) {
                    if(grape[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        result++;
                    } else if(grape[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
