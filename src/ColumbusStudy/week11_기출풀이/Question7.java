package ColumbusStudy.week11_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question7 {

    // https://www.acmicpc.net/problem/1874
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int s = 0;
        for(int i = 0; i < n; i++) {
            if (arr[i] > s) {
                for (int j = s + 1; j <= arr[i]; j++) {
                    st.push(j);
                    sb.append("+").append("\n");
                }
                s = arr[i];
            }

            if(!st.isEmpty() && st.peek() == arr[i]) {
                st.pop();
                sb.append("-").append("\n");
            } else {
                System.out.print("NO");
                System.exit(0);
            }
        }
        System.out.println(sb.toString());
    }
}
