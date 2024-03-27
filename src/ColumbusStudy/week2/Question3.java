package ColumbusStudy.week2;

import java.util.Scanner;
import java.util.Stack;

public class Question3 {
    // 후위 표기식
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        double[] arr = new double[n];

        // 문제 형태
        String str = kb.nextLine();
        Stack<Double> stack = new Stack<>();

        // 값 들어오는 순서
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

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
