package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char x : str.toCharArray()) {
            left.push(x);
        }

        while(n-- >0){
            // 다시 문자열 입력 받음 L P B D // 공백으로 구분하기 위해 " " 삽입.
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "L":
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P":
                    String x = st.nextToken();
                    left.push(x.charAt(0));
                    break;
                default:
                    break;

            }
        }
        // 전체 옮겨주는 작업
        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb.toString());
    }
}
