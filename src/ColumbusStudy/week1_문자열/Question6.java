package ColumbusStudy.week1_문자열;

import java.util.*;
import java.io.*;

public class Question6 {

    // https://www.acmicpc.net/problem/2609
    // 복습 완 ( 다시한번 더 볼것, 공식임!! )
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(GCD(n, m));
        System.out.println(LCM(n, m));
    }

    static int LCM(int a, int b){
        return (a * b) / GCD(a, b);
    }
    static int GCD(int a, int b){
        if ( b == 0 ) return a;
        else return GCD(b, a % b);
    }
}
