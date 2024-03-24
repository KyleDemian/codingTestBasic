package day10;

import java.util.Scanner;

public class Question3 {
    // 동적계획법!
    static int[] dy;

    public int solution(int[] arr) {
       int answer = 0;
        dy = new int[arr.length];
        dy[0]=1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                // 가장 앞의 항
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
                dy[i]=max+1;
                answer = Math.max(answer, dy[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question3 q = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }
        // 부분 증가 수열 ( LIS )
        // 순서를 유지하는 최대 증가
        // 자기 앞의 항의 값이 작다면 1 그냥 합산 더 크다면 그 항으로 값을 변경
        // 8
        // 5 3 7 8 6 2 9 4
        System.out.println(q.solution(arr));

    }
}
