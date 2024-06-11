package practice9_dp;

import java.util.*;
import java.io.*;

public class Question4 {

    // https://www.acmicpc.net/problem/1994
    // 등차 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        // i, j 의 마지막 등차수열의 최대 길이 값
        int[][] dy = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;

        if(N == 1) {
            System.out.print(1);
            return;
        }


        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                dy[i][j] = 2;
                // 등차 값 arr[i] - ( arr[j] - arr[i] );
                int pre = 2 * arr[i] - arr[j];
                int k = 0;
                for (k = i - 1; k >= 1; k--) {
                    if(arr[k] == pre) break;
                }
                dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
                answer = Math.max(answer, dy[i][j]);
            }
        }
        System.out.println(answer);
    }

}
