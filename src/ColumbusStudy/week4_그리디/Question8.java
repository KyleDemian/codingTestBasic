package ColumbusStudy.week4_그리디;

import java.util.Scanner;
import java.util.Stack;

public class Question8 {

    // https://www.acmicpc.net/problem/3986

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            String str = kb.nextLine();
            Stack<Character> stack = new Stack<>();

            for (char x : str.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == x) {
                    stack.pop();
                } else {
                    stack.push(x);
                }
            }

            if (stack.isEmpty()) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}


/*
    int count = str.length();
    for (int j = 0; j < count / 2; j++) {
        char a = str.charAt(j);
        char b = str.charAt(count-j-1);
        String ab = String.valueOf(a) + String.valueOf(b);
        if(ab.equals("AA") || ab.equals("BB") ){
            sum++;
        }
    }
 * */
