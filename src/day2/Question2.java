package day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {

    // https://cote.inflearn.com/contest/10/problem/02-02

    public int solution(int n, int[] arr) {
        int answer = 1, max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question2 T = new Question2();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        // 선생님이 볼 수 있는 최대 학생수 출력
        // 8
        // 130 135 148 140 145 150 150 153

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
