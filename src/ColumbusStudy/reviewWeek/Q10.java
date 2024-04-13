package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean checked = true;
            for (char x : str.toCharArray()) {
                if( x == '('){
                    stack.push(x);
                } else {
                    if (stack.isEmpty()) {
                        checked = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) checked = false;

            if (checked) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
