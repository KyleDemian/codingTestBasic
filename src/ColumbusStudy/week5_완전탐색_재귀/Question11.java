package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11 {

    // https://www.acmicpc.net/problem/22864
    // 복습 완
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum = 0;
        int tired = 0;
        for(int i = 0; i < 24 ; i++){
            if(tired + A <= M){
                sum += B;
                tired += A;
            } else {
                tired = Math.max(0, tired - C);
            }
        }
        System.out.print(sum);
    }
}
