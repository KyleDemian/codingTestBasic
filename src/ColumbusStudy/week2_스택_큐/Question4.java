package ColumbusStudy.week2_스택_큐;

import java.io.*;
import java.util.*;

public class Question4 {
    public static void main(String[] args) throws IOException {

        // https://www.acmicpc.net/problem/1874

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        int start = 0;

        // 미리 만든 배열값
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 총 돌아야 하는 배열 값 + 해당 배열을 푸쉬 할지 팝을 할지 정하는 부분
        for (int i = 0; i < n; i++) {
            if(arr[i] > start) {
                // 1회 기준 첫 입력값이 4니까 0 부터 3까지 ( 총 4회 )
                for(int j = start + 1; j <= arr[i]; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                start = arr[i];
            }

            // 1회때는 stack.size() 4 가 될것이고, 그리고 peek 값과 arr[i] 값이 4가 됌.
            if(!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println(sb.toString());

        //8
        //4
        //3
        //6
        //8
        //7
        //5
        //2
        //1
    }
}
