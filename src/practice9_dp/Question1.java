package practice9_dp;

import java.util.*;
import java.io.*;
public class Question1 {

    // https://www.acmicpc.net/problem/4781
    // 냅색 알고리즘 // 배낭, 동전 등등 전부다 // 기초강의 다시볼것
    // LIS, LCS, 냅색
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String a = br.readLine();
            StringTokenizer st = new StringTokenizer(a);
            // 사탕의 종류
            int n = Integer.parseInt(st.nextToken());
            int m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);

            // 종료 조건
            if("0 0.00".equals(a)) break;

            // 동적 계획법
            int[] dy = new int[m+1];

            // 총 개수만큼 입력 받음.
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
                for (int j = p; j <= m; j++) {
                    dy[j] = Math.max(dy[j], dy[j - p] + c);
                }
            }
            sb.append(dy[m]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
