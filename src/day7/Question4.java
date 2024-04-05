package day7;

import java.util.Scanner;

public class Question4 {

    // https://cote.inflearn.com/contest/10/problem/07-04

    // 메모이제이션
    static int[] fibo;

    public int DFS(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) {
        Question4 T = new Question4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n+1];
        T.DFS(n);

        // 피보나치 수열 ( 메모이제이션 ) -- 재귀랑 함수 둘다 짤줄 알아야함.
        // 45
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
//        System.out.print(T.DFS(n));
    }
}
