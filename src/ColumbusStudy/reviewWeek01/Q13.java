package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            String str = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char x : str.toCharArray()) {
                switch (x) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    default:
                        left.push(x);
                        break;
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            System.out.println(sb.toString());
        }
    }
}
