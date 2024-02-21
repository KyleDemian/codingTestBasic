package day1;

import java.util.Scanner;

public class Question2 {

    // https://cote.inflearn.com/contest/10/problem/01-02

    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x); // 65 ~ 90 대문자
            } else {
                answer += Character.toLowerCase(x); // 97 ~ 122 소문자
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question2 T = new Question2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        // 대문자를 소문자로, 소문자를 대문자로 변경
        // StuDY
        System.out.println(T.solution(str));
    }

}
