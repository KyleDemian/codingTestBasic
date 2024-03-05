package day5;

import java.util.Scanner;
import java.util.Stack;

public class Question4 {

    // https://cote.inflearn.com/contest/10/problem/05-04

    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {     // isDigit 숫자인지 문자인지 판단하는 것
                stack.push(x-48);       // 0 아스키넘버로 48임. 숫자로 변환
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') { stack.push(lt + rt); }
                else if (x == '-') {stack.push(lt - rt); }
                else if (x == '*') {stack.push(lt * rt); }
                else if (x == '/') {stack.push(lt / rt); }
            }
        }
        answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        Question4 T = new Question4();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        // 후위식 연산 (postfix) // 주로 인터뷰하면서 내는 문제임. rt lt -> rt를 먼저 빼고, 나중에 나온게 빼기나 곱샘이 됌.
        // 중위식일때는 어떻게 하는지도 확인 해볼것.
        // 352+*9-
        System.out.println(T.solution(str));
    }
}
