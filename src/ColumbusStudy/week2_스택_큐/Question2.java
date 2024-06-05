package ColumbusStudy.week2_스택_큐;

import java.util.*;
import java.io.*;

public class Question2 {

    // https://www.acmicpc.net/problem/9012
    // 복습 완
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            Stack<Character> st = new Stack<>();
            String str = br.readLine();
            boolean isCorrect = true;
            for(char x : str.toCharArray()){
                if(x == '('){
                    st.push(x);
                } else {
                    if(st.isEmpty()){
                        isCorrect = false;
                        break;
                    }
                    st.pop();
                }
            }
            if(!st.isEmpty() || !isCorrect) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
