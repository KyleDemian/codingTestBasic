package ColumbusStudy.week10_simul;

import java.util.*;
import java.io.*;

public class Question12 {

    // https://www.acmicpc.net/problem/2840
    // https://january-diary.tistory.com/entry/BOJ-2840-%ED%96%89%EC%9A%B4%EC%9D%98-%EB%B0%94%ED%80%B4-JAVA
    // 구현문제 및 시뮬레이션 문제임.

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] alphabet = new boolean[26];

        char[] roulette = new char[N];
        Arrays.fill(roulette, '?');

        int idx = 0;
        while (--K >= 0) {
            st = new StringTokenizer(in.readLine());
            idx = (idx + N - (Integer.parseInt(st.nextToken()) % N)) % N;
            char ch = st.nextToken().charAt(0);

            if (roulette[idx] == ch) continue;

            if (roulette[idx] == '?' && !alphabet[ch-'A']) {
                roulette[idx] = ch;
                alphabet[ch-'A'] = true;
            }
            else {
                System.out.println('!');
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(roulette[(idx + i) % N]);
        }
        System.out.println(sb);
    }
}


