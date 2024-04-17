package practice1;

import java.util.Arrays;

public class Question2 {

    // 시뮬레이션 & 구현
    // 배열의 이동
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int n = board.length;
        // 행 , 열 합
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0, x = 0, y = 0, d = 1;
        while(cnt < k){
            // 현재는 ( 0 , 0 ) , 움직여야 하니까 cnt + 1 초
            cnt++;
            // d > 오른쪽 방향 보기 시작. ( d가 direction )
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                d = (d+1) % 4; // 방향만 전환
                continue;
            }
            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    public static void main(String[] args){
        Question2 T = new Question2();
        int[][] arr1 = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
