package day7;

import java.util.Scanner;

public class Question3 {

    // https://cote.inflearn.com/contest/10/problem/07-03

    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Question3 T = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        // 팩토리얼 N!
        // 5
        System.out.print(T.DFS(n));
    }
}
