package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question6 {

    // https://www.acmicpc.net/problem/2231
    // 복습 완 ( 분해 합 )

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 1; i <= N; i++){
            int num = i;
            int res = 0;

            while( num > 0){
                res += num%10;
                num /= 10;
            }

            if((res+i) == N){
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }
}
