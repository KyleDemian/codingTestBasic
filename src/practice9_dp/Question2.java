package practice9_dp;

import java.util.*;
import java.io.*;
public class Question2 {

    // https://www.acmicpc.net/problem/2073
    // 냅색 다이나믹
    // 문제를 풀지 말지 선택하는 부분을 고려해야함.
    // 문제가 잘 이해가 안됌.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 거리 및 파이
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] dy = new int[D + 1];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            // 길이와 용량
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            for (int j = D; j > L; j--) {
                if(dy[j-L] == 0) continue;
                dy[j] = Math.max(dy[j], Math.min(dy[j - L], C));
            }
            dy[L] = Math.max(dy[L], C);
        }
        System.out.print(dy[D]);
    }
}
