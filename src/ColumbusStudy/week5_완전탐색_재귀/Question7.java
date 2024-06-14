package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question7 {

    // https://www.acmicpc.net/problem/18312
    // 복습 완
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String K = st.nextToken();

        int answer = 0;

        // 순서대로 시, 분 , 초
        for(int i = 0; i <= N; i++){
            for(int j = 0; j < 60; j++){
                for(int l = 0; l < 60; l++){
                    String h = (i < 10) ? "0" + i : i + "";
                    String m = (j < 10) ? "0" + j : j + "";
                    String s = (l < 10) ? "0" + l : l + "";

                    if(h.contains(K) || m.contains(K) || s.contains(K)) answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
