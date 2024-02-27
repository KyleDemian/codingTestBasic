package day2;

import java.util.Scanner;

public class Question10 {   // 2번 이상 들어볼것+

    // https://cote.inflearn.com/contest/10/problem/02-10
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    // dx, dy >>> 상하 좌우값을 구하기 위함.

    public int solution(int n, int[][] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if ((nx >= 0 && nx < n && ny >= 0 && ny < n) && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question10 T = new Question10();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        // 봉우리 지역 문제 -> 4방향을 기준으로 나보다 큰숫자가 있없을 경우만 봉우리로 선택
        // 5
        // 5 3 7 2 3
        // 3 7 1 6 1
        // 7 2 5 3 4
        // 4 3 6 4 1
        // 8 7 3 5 2
        System.out.println(T.solution(n, arr));
    }
}
