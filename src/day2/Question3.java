package day2;

import java.util.Scanner;

public class Question3 {

    // https://cote.inflearn.com/contest/10/problem/02-03

    public String solution(int n, int[] a, int[] b) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer += "D";
            } else if (a[i] == 1 && b[i] == 3) {
                answer += "A";
            } else if (a[i] == 2 && b[i] == 1) {
                answer += "A";
            } else if (a[i] == 3 && b[i] == 2) {
                answer += "A";
            } else {
                answer += "B";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question3 T = new Question3();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] a = new int[n];   // 가위바위보 결과 값 입력 n 만큼
        int[] b = new int[n];

        // 가위바위보
        // 5
        // 2 3 3 1 3
        // 1 1 2 2 3
        // 가위1, 바위2, 보3

        for (int i = 0; i < n; i++) { a[i] = kb.nextInt(); }
        for (int i = 0; i < n; i++) { b[i] = kb.nextInt(); }

        System.out.println(T.solution(n, a, b));
    }
}
