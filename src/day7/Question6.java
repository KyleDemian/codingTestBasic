package day7;

import java.util.Scanner;

public class Question6 {

    // https://cote.inflearn.com/contest/10/problem/07-06

    static int n;
    static int[] ch;
    public void DFS(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp.trim());
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        Question6 T = new Question6();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ch = new int[n + 1];
        // (이진트리) 부분 집합 구하기 ( 깊이우선탐색 : DFS )
        // 3
        T.DFS(1);
    }
}
