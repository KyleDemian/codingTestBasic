package day6;

import java.util.Arrays;
import java.util.Scanner;

public class Question9 {

    // https://cote.inflearn.com/contest/10/problem/06-09

    // DVD 장수
    public int count(int[] arr, int capacity) {
        int cnt = 1, sum=0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum+=x;
            }
        }
        return cnt;
    }

    public int solution(int n,int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2; // dvd 한장의 용량
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Question9 T = new Question9();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(n, m, arr));

        // 결정 알고리즘 ( 뮤직비디오 )    // DVD 최소 용량 크기를 출력해야함.
        // 이분검색을 이용하는 알고리즘임. // lt ~ rt 사이에 답이 잇다라고 확정 됐을때만 사용함. // m 의 값이 dvd 장수
        // mid 를 구했을때 해당 값이 데이터가 들어가는지 먼저 검증
        // 9 3
        // 1 2 3 4 5 6 7 8 9
        // 17
    }
}
