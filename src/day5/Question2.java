package day5;

import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    // https://cote.inflearn.com/contest/10/problem/05-02

    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Question2 T = new Question2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        // 괄호 개수 확인 () 해당 괄호에 있는 문자만 삭제 해야함.
        // (A(BC)D)EF(G(H)(IJ)K)LM(N)
        // EFLM
        System.out.print(T.solution(str));
    }
}
