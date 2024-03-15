package day8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point12{
    public int x, y;

    public Point12(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Question12 {

    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static Queue<Point12> q = new LinkedList<>();

    public void BFS() {
        while (!q.isEmpty()) {
            Point12 tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.x+dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny]=1;
                    q.offer(new Point12(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        Question12 mq = new Question12();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                board[i][j] = kb.nextInt();
                if(board[i][j] == 1) q.offer(new Point12(i, j));
            }
        }
        // 토마토 익는거.. ( BFS )
        // 6 4
        // 0 0 -1 0 0 0
        // 0 0 1 0 -1 0
        // 0 0 -1 0 0 0
        // 0 0 0 0 -1 1
        mq.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==0) flag = false;
            }
        }
        if (flag){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}
