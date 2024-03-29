package ColumbusStudy.week2;

import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    // https://www.acmicpc.net/problem/9012
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextLine();
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            boolean isValid = true;
            for (char x : arr[i].toCharArray()) {
                if(x == '('){
                    stack.push(x);
                } else {
                    if(stack.isEmpty()){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) isValid = false;

            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
