package day8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point14{
    int x,y;

    public Point14(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Question14 {    // 하나도 이해가 안되네 수열은;;
    static int answer = 0, n;
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point14> qu = new LinkedList<>();

    public void BFS(int x, int y, int[][] board) {
        qu.add(new Point14(x, y));
        while (!qu.isEmpty()) {
            Point14 pos = qu.poll();
        }
        // 해당 부분은 현재 지점에서는 방향이기때문에 -> 0~7 까지 총 8번
        for (int i = 0; i < 8; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >=0 && nx < n && ny>= 0 && ny<n && board[nx][ny]==1){
                board[nx][ny]=0;
                qu.add(new Point14(nx, ny));
            }
        }
    }

    public void solution(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Question14 q = new Question14();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        q.solution(arr);
        System.out.println(answer);

        // 섬나라 아일랜드 // 육지 1 방향은 총 8방향으로 섬이 몇개있는지 확인
        // 7
        // 1 1 0 0 0 1 0
        // 0 1 1 0 1 1 0
        // 0 1 0 0 0 0 0
        // 0 0 0 1 0 1 1
        // 1 1 0 1 1 0 0
        // 1 0 0 0 1 0 0
        // 1 0 1 0 1 0 0
    }
}
