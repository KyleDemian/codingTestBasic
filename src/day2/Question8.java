package day2;

import java.util.Scanner;

public class Question8 {

    // https://cote.inflearn.com/contest/10/problem/02-08

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        Question8 T = new Question8();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = kb.nextInt();
        }

        // 등수 구하기
        // 5
        // 87 89 92 100 76
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
