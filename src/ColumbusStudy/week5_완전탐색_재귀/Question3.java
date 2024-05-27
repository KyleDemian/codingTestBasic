package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3 {

    // https://www.acmicpc.net/problem/25501
    // 펠린드롬 -> 문자열

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        for(int i = 0; i < n; i++) {
            str[i] = br.readLine();

            // https://www.acmicpc.net/submit/25501/77314397
            // 분명 처음에 풀었었는데, 문제가 cnt 초기화 위치가 아래였음..
            cnt = 0;
            int result = isPalindrome(str[i]);
            System.out.println(result + " " + cnt);
        }
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
}
