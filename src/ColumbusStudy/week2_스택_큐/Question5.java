package ColumbusStudy.week2_스택_큐;

import java.io.*;
import java.util.*;

public class Question5 {
    // https://www.acmicpc.net/problem/5397
    // 복습 완
    // 참고 https://upcurvewave.tistory.com/633

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            StringBuilder sb = new StringBuilder();
            Stack<Character> l = new Stack<>();
            Stack<Character> r = new Stack<>();
            String str = br.readLine();

            for(char x : str.toCharArray()){
                if(x == '<') {if(!l.isEmpty()) r.push(l.pop());}
                else if(x == '>') {if(!r.isEmpty()) l.push(r.pop());}
                else if(x == '-') {if(!l.isEmpty()) l.pop();}
                else l.push(x);
            }

            while(!l.isEmpty()) r.push(l.pop());
            while(!r.isEmpty()) sb.append(r.pop());

            System.out.println(sb.toString());
        }
    }
}
