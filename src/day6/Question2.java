package day6;

import java.util.Scanner;

public class Question2 {

    // 버블 정렬
    // 가장 큰 수가 맨 뒤로감
    // 비교횟수가 점점 -1씩 줄어듬
    // https://cote.inflearn.com/contest/10/problem/06-02
    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {   // 턴의 횟수 N-1 바퀴
            for (int j = 0; j < n - i - 1; j++) {   // 1번씩 덜돌아야함.
                if (arr[j] > arr[j + 1]) {  // 앞 > 뒤
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Question2 T = new Question2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 버블 정렬 - 이웃한 두수를 비교함.
        // 6
        // 13 5 11 7 23 15
        for (int x : T.solution(n, arr)){
            System.out.print(x + " ");
        }
    }
}
