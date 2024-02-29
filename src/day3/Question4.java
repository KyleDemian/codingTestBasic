package day3;

import java.util.Scanner;

public class Question4 {

    // https://cote.inflearn.com/contest/10/problem/03-04

    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt=0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                answer++;
            }

            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question4 T = new Question4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 연속 부분 수열 ( N 개로 이뤄진 수열 )
        // 8 6
        // 1 2 1 3 1 1 1 2

        System.out.println(T.solution(n, m , arr));
    }
}
