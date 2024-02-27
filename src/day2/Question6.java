package day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Question6 {

    // https://cote.inflearn.com/contest/10/problem/02-06

    // 소수
    public boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;   // 1의 자리 정수값.
                res = res * 10 + t; // 뒤짚은 결과를 저장
                tmp = tmp / 10;     // 몫
            }
            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question6 T = new Question6();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 뒤짚은 소수 -> 들어온 숫자값을 리버스 해서 해당 값이 소수인지 확인하는 문제
        // 9
        // 32 55 62 20 250 370 200 30 100

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }

    }
}

