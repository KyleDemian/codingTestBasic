package day8;

import java.util.List;
import java.util.Scanner;

public class Question2 {

    static int answer=Integer.MIN_VALUE, n, c;
    public void DFS(int l, int sum,int[] arr) {
        if(sum>c) return;
        if (l == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(l + 1, sum + arr[l], arr);
            DFS(l + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        q.DFS(0, 0, arr);
        System.out.println(answer);
        // 바둑이 상자 (DFS - 부분집합)
        // 259 5
        // 81
        // 58
        // 42
        // 33
        // 61
    }
}
