package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q34 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char x : str.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == x) {
                    stack.pop();
                } else {
                    stack.push(x);
                }

                if(stack.isEmpty()) sum++;
            }
        }

        System.out.println(sum);

    }
}
