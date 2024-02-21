package day1;

import java.util.Scanner;

public class Question5 {

    // https://cote.inflearn.com/contest/10/problem/01-05

    public String solution(String str) {
        String answer = "";
        char[] s = str.toCharArray();   // 문자를 1글자씩 배열로 변경
        int lt = 0, rt = str.length()-1;
        while (lt < rt) {
            if (!Character.isAlphabetic(s[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(s);

        return answer;
    }

    public static void main(String[] args) {
        Question5 T = new Question5();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        // 특수문자를 제외하고, 앞뒤글자 변경
        // a#b!GE*T@S
        System.out.print(T.solution(str));
    }
}
