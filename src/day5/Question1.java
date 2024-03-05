package day5;

import java.util.Scanner;
import java.util.Stack;

public class Question1 {

    // https://cote.inflearn.com/contest/10/problem/05-01

    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Question1 T = new Question1();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        // Stack LIFO
        // 괄호 개수 확인
        // ((())())(
        System.out.print(T.solution(str));
    }
}
