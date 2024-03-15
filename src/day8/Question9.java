package day8;

import java.util.Scanner;

public class Question9 {    // 하나도 이해가 안되네 수열은;;
    static int[] combi;
    static  int n, m;

    public void DFS(int l, int s) {
        if (l == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n ; i++) {
                combi[l] = i;
                DFS(l + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Question9 q = new Question9();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        q.DFS(0, 1);
        // 조합 구하기
        // 4 2
    }
}
