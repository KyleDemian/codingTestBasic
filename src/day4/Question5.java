package day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Question5 {

    // https://cote.inflearn.com/contest/10/problem/04-05

    public int solution(int[] arr, int n, int k) {
        int answer = 0;
        // 중복제거 및 정렬까지 자동으로 됌.
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        // 들어온 배열값들의 전부 합산 ( 중복을 제거 하기 위해 현재값 +1 )
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;

        // Tset의 경우 자동으로 역순으로 정렬됌, 저렬된 값의 k 값을 추출
        for (int x : Tset) {
            cnt++;
            if (cnt == k) {
                answer = x;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Question5 T = new Question5();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // k 번째 큰 수 - 3장을 뽑으니까 3중 포문을 돌려서 가장 큰수를 뽑아내야함.
        // 10 3
        // 13 15 34 23 45 65 33 11 26 42
        System.out.println(T.solution(arr, n ,k));
    }
}
