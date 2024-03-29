package ColumbusStudy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Question6 {
    // https://www.acmicpc.net/problem/1406
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 최초 문자열 입력 받음
        String str = br.readLine();
        // 문자열만큼 데이터 입력 받아야 함
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 최초 문자 전부다 왼쪽 삽입.
        for (char x : str.toCharArray()) {
            left.push(x);
        }

        // 문자열 만큼 회전
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
