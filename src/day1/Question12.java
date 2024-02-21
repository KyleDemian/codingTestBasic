package day1;

import java.util.Scanner;

public class Question12 {

    // https://cote.inflearn.com/contest/10/problem/01-12

    public String solution(int n, String str) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace("#", "1").replace("*","0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {
        Question12 T = new Question12();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        // 글자를 7글자씩 잘라서, 해당 글자를 2진수로 변환, 2진수 값을 (char, 2 ) 로 호출시 해당 글자가 변환됌
        // 4
        // #****###**#####**#####**##**
        System.out.println(T.solution(n, str));
    }
}
