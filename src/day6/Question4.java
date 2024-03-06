package day6;

import java.util.Scanner;

public class Question4 {

    // https://cote.inflearn.com/contest/10/problem/06-04   // 문제 다시 읽어볼것.

    public int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1; // index
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }
            // miss 상황 1개씩 당김
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }else{
            // Hit 처리 -> hit 지점부터 -1개씩
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        return cache;
    }

    public static void main(String[] args) {
        Question4 T = new Question4();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // LRU ( Least Recently Used ) - kakao (가장 최근에 사용되지 않은것 )
        // 5 9  // 캐시사이즈, 작업 9개
        // 1 2 3 2 6 2 3 5 7
        for (int x : T.solution(s, n, arr)){
            System.out.print(x + " ");
        }
    }
}
