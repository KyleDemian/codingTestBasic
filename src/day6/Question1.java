package day6;

import java.util.Scanner;

public class Question1 {

    // 선택 정렬 -> 인덱스값을 기준으로 가져옴
    // https://cote.inflearn.com/contest/10/problem/06-01
    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;    // arr 인덱스 값
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Question1 T = new Question1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 선택 정렬
        // 6
        // 13 5 11 7 23 15
        for (int x : T.solution(n, arr)){
            System.out.print(x + " ");
        }
    }
}
