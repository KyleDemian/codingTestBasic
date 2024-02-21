package day1;

import java.util.Scanner;

public class Question11 {

    // https://cote.inflearn.com/contest/10/problem/01-11

    public String solution(String str) {
        String answer = "";
        str = str + " ";
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                cnt++;
            } else {
                answer += str.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question11 T = new Question11();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        // 현재 글자와 앞의 글자가 같다면 카운트 값을 올리고, 같지 않다면 다음글자로 넘어감.
        // KSTTTSEEKFKKKDJJGG
        System.out.print(T.solution(str));
    }
}
