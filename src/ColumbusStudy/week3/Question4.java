package ColumbusStudy.week3;

import java.util.Scanner;
import java.util.Stack;

public class Question4 {

    // https://www.acmicpc.net/problem/10773

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k ; i++){
            int n = kb.nextInt();
            if( n != 0 ){
                stack.push(n);
            } else {
                stack.pop();
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }


        System.out.print(sum);
    }
}
