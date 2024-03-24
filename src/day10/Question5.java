package day10;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
    // 첫번째 줄에 거슬러줄 동전의 최소 갯수.
    static int[] dy;
    static  int n, m;
    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i] + 1]);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        Question5 q = new Question5();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }
        m = kb.nextInt();
        dy = new int[m + 1];    // 방의 개수

        // 동전 교환 ( 냅색 알고리즘 )
        // 순서를 유지하는 최대 증가
        // 3
        // 1 2 5
        // 15
        System.out.println(q.solution(arr));

    }
}
