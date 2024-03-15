package day8;

import java.util.Scanner;

public class Question7 {
    // 메모이제이션
    int[][] dy = new int[35][35];
    public int DFS(int n, int m) {
        if(dy[n][m] > 0) return dy[n][m];
        if (n == m || m == 0) {
            return 1;
        } else {
            return dy[n][m] = DFS(n - 1, m - 1) + DFS(n - 1, m);
        }
    }

    public static void main(String[] args) {
        Question7 q = new Question7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ;
        System.out.println(q.DFS(n, m));
        // 조합의 경우의 수 (메모이제이션) 5C3
        // 5명중 내가 참가한 경우/ 참가하지 않은케이스 2개만 존재
        // 4c2 // 4c3 이라고 생각하면 됌.
        // 5 3
    }
}
