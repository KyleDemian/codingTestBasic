package day2;

import java.util.Scanner;

public class Question5 {

    // https://cote.inflearn.com/contest/10/problem/02-05

    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];  // 배열 숫자 생기는것땜시 +1 해야함. ( 기본 인덱스 시작은 0 )
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                // 해당 값의 배수들은 전체 체크를 하고 넘어감. 그 결과를 n번까지. 진행
                System.out.println(i);
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question5 T = new Question5();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        // 뒤짚은 소수 ( 에라토스테네스 체 n+1)
        // 20
        System.out.println(T.solution(n));
    }
}
