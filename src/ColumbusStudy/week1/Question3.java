package ColumbusStudy.week1;

import java.util.Scanner;

public class Question3 {
    // https://www.acmicpc.net/problem/1157
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next().toUpperCase();
        int[] cnt = new int[26];
        int max = 0;
        char result = '?';

        for (char x :  str.toCharArray()){
            cnt[x-'A']++;
            if(max < cnt[x - 'A']){
                max = cnt[x-'A'];
                result = x;
            } else if(max == cnt[x -'A']){
                result = '?';
            }
        }
        System.out.println(result);

        
    }
}
