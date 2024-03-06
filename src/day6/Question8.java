package day6;

import java.util.Arrays;
import java.util.Scanner;

public class Question8 {

    // https://cote.inflearn.com/contest/10/problem/06-08
    // 알고리즘 배우기 // 이분검색 시작 정렬 -> n/2 로 나누고 그 값 을 찾기.

    public int solution(int n,int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) {
                rt = mid -1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question8 T = new Question8();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();   // 배열
        int m = kb.nextInt();   // 찾을 숫자

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n, m, arr));

        // 이분 검색 - 가장 먼저 정렬을 먼저 해야함. ( 바이너리 서치 알고리즘 )
        // 8 32
        // 23 87 65 12 57 32 99 81
    }
}
