package ColumbusStudy.week2;

import java.util.Scanner;
import java.util.Stack;

public class Question3 {

    // https://www.acmicpc.net/problem/1935
    // 후위 표기식
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        double[] arr = new double[n];

        // 문제 형태
        // A B C D E F 는 어차피 대문로 해당 하는 값을 때면 해당 숫자랑 매칭됌
        String str = kb.nextLine();
        Stack<Double> stack = new Stack<>();

        // 값 들어오는 순서 1 2 3 4 5
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }


        // 파이프 라인 스위치 명령어 사용시 속도 향상이 가능함
        // >> 컴파일러에따라서 다르다고 함, 확인해볼것-_-b
        double answer = 0;
        for (char x : str.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                int index = x - 'A';
                stack.push(arr[index]); // 1 2 3 4 5 순서대로
            } else {
                double rt = stack.pop();
                double lt = stack.pop();
                if(x == '+') stack.push(lt +  rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }

        answer = stack.peek();
        System.out.printf("%.2f", answer);

        // 5
        // ABC*+DE/-
        // 1
        // 2
        // 3
        // 4
        // 5
    }
}
