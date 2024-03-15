package day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Question6 {

    static int n, m;
    static int[] pm, ch, arr;

    public void DFS(int l) {
        if (l == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] ==0) {
                    ch[i] = 1;
                    pm[l] = arr[i];
                    DFS(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question6 q = new Question6();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];    // 이 부분을 수정했습니다
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        q.DFS(0);
        // 순열 구하기 ( 순열 구하기 - 중복된 값 제외)
        // 3 2
        // 3 6 9
    }
}
