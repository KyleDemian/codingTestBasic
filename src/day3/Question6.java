package day3;

import java.util.Map;
import java.util.Scanner;

public class Question6 {        // 개 햇갈리넹 - 이해는되는데 ... 해답보니 후.. 문제가 어렵네


    // https://cote.inflearn.com/contest/10/problem/03-06

    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;

            while (cnt > k) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Question6 T = new Question6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 최대 길이 연속부분수열
        // 14 2
        // 1 1 0 0 1 1 0 1 1 0 1 1 0 1

        System.out.println(T.solution(n, k, arr));
    }
}
