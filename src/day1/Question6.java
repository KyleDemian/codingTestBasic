package day1;

import java.util.Scanner;

public class Question6 {    // 1번 더 풀어볼것.. 틀림 ㅠ

    // https://cote.inflearn.com/contest/10/problem/01-06

    public String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            // 자기 문자와 자기 위치와 같았을 경우만, 문자열을 더함.
            // indexOf(str) 첫번째로 나타내는 문자열의 값을 나타냄.
//            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            // k 0 0
            // s 1 1
            // e 2 2
            // k 3 0
            // k 4 0
            // s 5 1
            // e 6 2
            // t 7 7
            // i == indexOf(String.charAt(i)) 같은걸 찾음.
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question6 T = new Question6();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        // ex : ksekkset
        System.out.print(T.solution(str));
    }
}
