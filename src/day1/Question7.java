package day1;

import java.util.Scanner;

public class Question7 {

    // https://cote.inflearn.com/contest/10/problem/01-07

    public String solution(String str) {
        String answer = "YES";

//        str = str.toUpperCase();
//        int len = str.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (str.charAt(i) != str.charAt(len - i - 1)) {
//                return answer = "NO";
//            }
//        }

        String tmp = new StringBuilder(str).reverse().toString();
        if (!str.equalsIgnoreCase(tmp)) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Question7 T = new Question7();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        // ex : gooG // 회문 문자열 앞뒤가 같은 문자 // 펠린드럼
        System.out.print(T.solution(str));
    }
}
