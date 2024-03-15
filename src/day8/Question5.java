package day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Question5 {

    static int n, m, answer=Integer.MAX_VALUE;
    public void DFS(int l, int sum, Integer[] arr) {
        if (sum > m) return;
        if (l >= answer) return;

        if (sum == m) {
            answer = Math.min(answer, l);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(l + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Question5 q = new Question5();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        // 객체형으로 변경함.
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        q.DFS(0,0, arr);
        // 3번째 거슬러 줄 동전의 최소 개수를 구하라 // 동전은 3개, 종류 , 총 합
        // 3
        // 1 2 5
        // 15
        System.out.println(answer);
    }
}
