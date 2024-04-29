package day8;

import java.util.Scanner;

public class Question13 {
    static int answer = 0, n;
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};

    public void DFS(int x, int y, int[][] board) {
        // 해당 부분은 현재 지점에서는 방향이기때문에 -> 0~7 까지 총 8번
        for (int i = 0; i < 8; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >=0 && nx < n && ny>= 0 && ny<n && board[nx][ny]==1){
                board[nx][ny]=0;
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Question13 q = new Question13();
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
