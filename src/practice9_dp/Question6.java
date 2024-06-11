package practice9_dp;

import java.util.*;
import java.io.*;
public class Question6 {

    // https://www.acmicpc.net/problem/1823
    // 수확 다이나믹
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dynamic = new int[N + 1][N + 1];
        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dynamic[i][i] = arr[i];
        }

        sum[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];

        }

        for (int i = 1; i < N ; i++) {
            for (int j = 1; j <= N - i; j++) {
                dynamic[j][j + i] = Math.max(dynamic[j + 1][j + i], dynamic[j][j + i - 1]) + (sum[j + i] - sum[j - 1]);
            }
        }

        System.out.println(dynamic[1][N]);
    }
}