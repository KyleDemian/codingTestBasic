package ColumbusStudy.week9_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question9 {
    // https://www.acmicpc.net/problem/15652

    static int N, M;
    static int[] value;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        value = new int[M];

        DFS(1, 0);

        System.out.println(sb.toString());
    }

    static void DFS(int at, int depth) {
        if(depth == M){
            for (int val : value) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = at; i <= N; i++) {
                value[depth] = i;
                DFS(i, depth + 1);
            }
        }
    }
}

