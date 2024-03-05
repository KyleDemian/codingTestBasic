package day5;

import java.util.Scanner;
import java.util.Stack;

public class Question5 {

    // https://cote.inflearn.com/contest/10/problem/05-05 // 올림피아드 stack   -> 문제 이해가 안돼... 두번 세번 그냥 배껴도;;

    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {     // 레이저 지점.
                    answer += stack.size();
                } else {
                    answer++;   // 막대기 끝
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question5 T = new Question5();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        // 쇠막대기
        // ()(((()())(())()))(())
        // (((()(()()))(())()))(()())
        System.out.println(T.solution(str));
    }
}
