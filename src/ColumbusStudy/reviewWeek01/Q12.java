package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > start) {
                for (int j = start+1; j <= arr[i]; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                start = arr[i];
            }

            if (!stack.isEmpty() && arr[i] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println(sb.toString());
    }
}
