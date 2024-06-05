package ColumbusStudy.week1_문자열;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Question4 {

    // https://www.acmicpc.net/problem/9996
    // 복습 완 ( 2024 06 04 )

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String p = br.readLine().replace("*", ".*");

        while(N-- > 0){
            String str = br.readLine();
            if(Pattern.matches(p, str)) sb.append("DA").append("\n");
            else sb.append("NE").append("\n");
        }

        System.out.print(sb.toString());
    }
}
