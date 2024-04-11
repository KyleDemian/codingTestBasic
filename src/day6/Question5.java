package day6;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {

    // https://cote.inflearn.com/contest/10/problem/06-05

    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question5 T = new Question5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 정렬 및 중복 확인
        // 8
        // 20 25 52 30 39 33 43 33
        System.out.println(T.solution(n, arr));
    }
}
