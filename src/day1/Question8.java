package day1;

import java.util.Scanner;

public class Question8 {

    // https://cote.inflearn.com/contest/10/problem/01-08

    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Question8 T = new Question8();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        // ex : found7, time: study; Yduts; emit, 7Dnuof // 팰린드론 앞으로 읽으나 뒤로읽으나 같은
        System.out.print(T.solution(str));
    }
}
