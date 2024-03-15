package day1;

import java.util.Scanner;

public class Question9 {

    // https://cote.inflearn.com/contest/10/problem/01-09

    public int solution(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {       // char x 48 ~ 57 Number -> 0 ~ 9
                answer = answer * 10 + (x - 48);
            }
        }

        // StringBuilder sb = new StringBuilder();
        //
        // for (char c : str.toCharArray()) {
        //     if (Character.isDigit(c)) {
        //         sb.append(c);
        //     }
        // }
        // return sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        Question9 T = new Question9();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        // ex : g0en2T0s8eSoft // 숫자만 추출
        System.out.print(T.solution(str));
    }
}
