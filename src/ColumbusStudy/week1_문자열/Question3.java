package ColumbusStudy.week1_문자열;

import java.util.Scanner;

public class Question3 {
    // https://www.acmicpc.net/problem/1157
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next().toUpperCase();
        int[] cnt = new int[26];
        int max = 0;
        char result = '?';

        // 초기 배열값은 0 인데, 해당 값이 노출될때마다 해당 위치의 숫자 값을 +1 +1 +1 한다는의미임

        for (char x : str.toCharArray()){
            // str 에 있는 문자값이라면 +1이 됌!
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
