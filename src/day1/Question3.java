package day1;

import java.util.Scanner;

public class Question3 {

    // https://cote.inflearn.com/contest/10/problem/01-03

    public String solution(String str) {
        String answer = "";

        int m = 0;
        String[] s = str.split(",");
        for (String x : s) {
            /** 가장 긴거 뽑기
            int length = x.length();
            if (length > m) {
                m = length;
                answer = x;
            }
            */
            answer += x + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        Question3 T = new Question3();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        // 글자를 잘라서, 해당 글자를 잘라서 출력
        // it,is,time,to,study
        System.out.print(T.solution(str));
    }

}
