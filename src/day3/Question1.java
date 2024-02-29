package day3;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {

    // https://cote.inflearn.com/contest/10/problem/03-01

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;  // pointer 배열의 값
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                answer.add(a[p1++]);    // add를 하고 값을 증가 후위증가연산자
            } else {
                answer.add(b[p2++]);
            }
        }

        // 나머지 값을 넣기 위해
        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args) {
        Question1 T = new Question1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }

        // 두 배열 합치기 - 알고리즘 시간복잡도 (nLog n)
        // 3
        // 1 3 5
        // 5
        // 2 3 6 7 9

        for (int x : T.solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }
}
