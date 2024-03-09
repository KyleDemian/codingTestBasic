package day7;

import java.util.Scanner;

public class Question2 {

    // https://cote.inflearn.com/contest/10/problem/07-02

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            // 1 1 0 1
            System.out.print(n%2 + " ");
            DFS(n / 2);
            // 1 0 1 1
            System.out.print(n%2 + " ");
        }
    }

    public static void main(String[] args) {
        Question2 T = new Question2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        // 재귀 함수 - 10진수 N이 입력되면 2진수로 변환되는 프로그램 작성
        // 11
        T.DFS(n);
    }
}
