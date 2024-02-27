package day2;

import java.util.Scanner;

public class Question9 {

    // https://cote.inflearn.com/contest/10/problem/02-08

    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1 , sum2 ;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];  // 행의 합
                sum2 += arr[j][i];  // 열의 합
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        // 대각선
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) {
        Question9 T = new Question9();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        // 격자판 최대 합
        // 5
        // 10 13 10 12 15
        // 12 39 30 23 11
        // 11 25 50 53 15
        // 19 27 29 37 27
        // 19 13 30 13 19
        System.out.println(T.solution(n, arr));
    }
}
