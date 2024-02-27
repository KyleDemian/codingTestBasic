package day2;

import java.util.Scanner;

public class Question12 {

    // https://cote.inflearn.com/contest/10/problem/02-12

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }
                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question12 T = new Question12();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        // 멘토링 ( 멘토 멘티 I , j ) // 멘토가 멘티보다 성적이 높아야함.
        // 테스트 숫자 // 테스트 횟수
        // 4 3
        // 3 4 1 2
        // 4 3 2 1
        // 3 1 4 2
        System.out.println(T.solution(n, m, arr));
    }
}
