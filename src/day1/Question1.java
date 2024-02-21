package day1;

import java.util.Scanner;

public class Question1 {

    // https://cote.inflearn.com/contest/10/problem/01-01

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for (char x : str.toCharArray()) {
            if (x == t) {
                answer++;
            }
        }

//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == t){
//                answer++;
//            }
//        }

        return answer;
    }

    public static void main(String[] args) {
        Question1 T = new Question1();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        // 특정 문자 몇개 있는지
        // Computercooler
        // c
        System.out.println(T.solution(str,c));
    }

}
