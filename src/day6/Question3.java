package day6;

import java.util.Scanner;

public class Question3 {

    // https://cote.inflearn.com/contest/10/problem/06-03

    public int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if(arr[j]> tmp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Question3 T = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 삽입 정렬 > 첫번째부터 순서대로 값을 비교
        // 6
        // 13 5 11 7 23 15
        for (int x : T.solution(n, arr)){
            System.out.print(x + " ");
        }
    }
}
