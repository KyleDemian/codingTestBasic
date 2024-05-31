package ColumbusStudy.week9_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question10 {
    // https://www.acmicpc.net/problem/15649
    // https://velog.io/@taeeeeun/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9-Backtracking

    static int N, M;
    static int[] ch, value;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new int[N + 1];
        value = new int[N + 1];

        DFS(0);
        // 숫자 1 ~ N 까지
        // M 열
        System.out.println(sb.toString());
    }

    static void DFS(int index){
        if(index == M){
            for (int i = 0; i < M; i++) {
                sb.append(value[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if(ch[i] == 1){ continue; } // 중복숫자 제거
                ch[i] = 1;
                value[index] = i;
                DFS(index + 1);
                ch[i] = 0;
            }
        }
    }
}
