package day10;

import java.util.Scanner;

public class Question1 {

    // 피보나치 수열과 비슷하게 감.
    static int[] dy;

    public int solution(int n) {
        dy[1]=1;
        dy[2]=2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Question1 q = new Question1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(q.solution(n));

        // 동적계획법 - Dynamic programming  // 작은 문제로 나눠서 작업
        // 7
    }
}
