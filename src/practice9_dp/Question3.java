package practice9_dp;

import java.util.*;
import java.io.*;
public class Question3 {

    // https://www.acmicpc.net/problem/2579
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dy = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dy[0] = 0;
        dy[1] = arr[1];
        if(n > 1) dy[2] = arr[2] + arr[1];
        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i - 2] + arr[i], dy[i - 3] + arr[i - 1] + arr[i]);
        }

        System.out.println(dy[n]);
    }
}
