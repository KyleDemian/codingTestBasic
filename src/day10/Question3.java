package day10;

import java.util.Scanner;

public class Question3 {
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
        Question3 q = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }
        // 부분 증가 수열
        // 순서를 유지하는 최대 증가
        // 자기 앞의 항의 값이 작다면 1 그냥 합산 더 크다면 그 항으로 값을 변경
        // 8
        // 5 3 7 8 6 2 9 4
        System.out.println(q.solution(n));

        // 돌다리 건너기, 1칸 또는 2칸씩만 걸을 수 있음 Question1 이랑 완전 똑같음.
        // 7
    }
}
