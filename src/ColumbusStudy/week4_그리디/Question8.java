package ColumbusStudy.week4_그리디;

import java.io.*;
import java.util.Stack;

public class Question8 {

    // https://www.acmicpc.net/problem/3986
    // 복습 완

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while(N-- > 0){
            Stack<Character> st = new Stack<>();
            char[] c = br.readLine().toCharArray();

            for(int i = 0; i < c.length; i++){
                if(!st.isEmpty() && st.peek() == c[i]){
                    st.pop();
                } else {
                    st.push(c[i]);
                }
            }

            if(st.isEmpty()) result++;
        }

        System.out.print(result);
    }
}