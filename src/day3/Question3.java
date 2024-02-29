package day3;

import java.util.Scanner;

public class Question3 {

    // https://cote.inflearn.com/contest/10/problem/03-03

    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0;

        // 시작전 초기값 m 의 값만큼 합을 구함 ( 그 이후부터 슬라이드 )
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        for (int i = m; i < n; i++) {
            sum += (arr[i] - arr[i - m]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Question3 T = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        // 최대 매출액 구하기 // 슬라이딩 윈도우
        // 10 3
        // 12 15 11 20 25 10 20 19 13 15

        System.out.println(T.solution(n, m, a));
    }
}
