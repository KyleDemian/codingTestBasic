package day10;

import java.util.Scanner;

public class Question2 {
    // 피보나치 수열과 비슷하게 감.
    // 동적계획법!
    static int[] dy;

    public int solution(int n) {
        dy[1]=1;
        dy[2]=2;
        for (int i = 3; i <= n+1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n+1];
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        // 7이면 8이 되어야만 마지막 건너기가 됌
        dy = new int[n + 2];
        System.out.println(q.solution(n));

        // 돌다리 건너기, 1칸 또는 2칸씩만 걸을 수 있음 Question1 이랑 완전 똑같음.
        // 7
    }
}
