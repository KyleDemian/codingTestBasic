package day2;

import java.util.Scanner;

public class Question7 {

    // https://cote.inflearn.com/contest/10/problem/02-07

    public int solution(int n, int[] arr) {
        int answer = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question7 T = new Question7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 정수 계산 문제 > 1을 만날 경우 점수 누적하는 문제
        // 10
        // 1 0 1 1 1 0 0 1 1 0

        System.out.print(T.solution(n, arr));
    }
}
