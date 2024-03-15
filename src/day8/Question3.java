package day8;

import java.util.Scanner;

public class Question3 {

    static int answer=Integer.MIN_VALUE, n, m;
    public void DFS(int l, int sum, int time ,int[] ps , int[] pt) {
        if(time > m) return;

        if (l == n) {
            answer = Math.max(answer, sum);
        } else {
            // 풀엇을때
            DFS(l + 1, sum + ps[l], time + pt[l], ps, pt);
            // 풀지 않았을때
            DFS(l + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) {
        Question3 q = new Question3();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
            b[i] = kb.nextInt();
        }

        q.DFS(0, 0, 0, a, b);
        System.out.println(answer);
        // 최대 점수 구하기 (DFS - 부분집합) // 점수 // 분
        // 5 20
        // 10 5
        // 25 12
        // 15 8
        // 6 3
        // 7 4
    }
}
