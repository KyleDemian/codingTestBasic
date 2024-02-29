package day3;

import java.util.Scanner;

public class Question5 {

    // https://cote.inflearn.com/contest/10/problem/03-05

    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;  // 연속된 자연수 +1
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question5 T = new Question5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        // 연속된 자연수의 합 ( 자연수 )
        // 15

        System.out.println(T.solution(n));
    }
}
