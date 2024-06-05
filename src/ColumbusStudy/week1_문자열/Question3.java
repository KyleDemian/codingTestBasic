package ColumbusStudy.week1_문자열;

import java.util.*;
import java.io.*;

public class Question3 {
    // https://www.acmicpc.net/problem/1157
    // 복습 완 ( 2024 06 04 )

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] cnt = new int[26];
        int max = 0;

        char result = '?';
        for(char c : str.toCharArray()){
            cnt[c - 'A']++;

            if(cnt[c - 'A'] > max){
                max = cnt[c-'A'];
                result = c;
            } else if(cnt[c-'A'] == max){
                result = '?';
            }
        }

        System.out.print(result);

    }
}
