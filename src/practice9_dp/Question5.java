package practice9_dp;

import java.util.*;
import java.io.*;
public class Question5 {

    // https://www.acmicpc.net/problem/1695
    // 부분 수열을 팰린드롬을 만들때 끼워넣는 최소 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[][] dy = new int[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n-1 ; j++) {
                if(arr[j] == arr[j+i]) dy[j][j + 1] = dy[j + 1][j + 1 - 1];
                else dy[j][j + 1] = Math.min(dy[j + 1][j + 1], dy[j][j + i - 1]) + 1;
            }
        }

        System.out.println(dy[1][n]);
    }
}
