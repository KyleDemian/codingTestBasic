package day3;

import java.util.Scanner;

public class Question5_2 {

    // https://cote.inflearn.com/contest/10/problem/03-05

    public int solution(int n) {
        int answer = 0, cnt = 1;    // 연속된 자연수의 개수임.
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt;
            if ((n%cnt) == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question5_2 T = new Question5_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        // 연속된 자연수의 합 ( 수학 )
        // 15

        System.out.println(T.solution(n));
    }
}
