package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1 {

    // https://www.acmicpc.net/problem/2455
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;  // 내린 사람
        int b = 0;  // 타는 사람
        int now = 0;
        int max = 0;

        // 총 4개의 정류장 // 무조건 다 내리고!, 다 탄다!
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            now -= a;
            now += b;
            max = Math.max(max, now);
        }
        System.out.println(max);
    }
}
