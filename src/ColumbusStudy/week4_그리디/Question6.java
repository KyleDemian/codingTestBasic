package ColumbusStudy.week4_그리디;

import java.io.*;
import java.util.*;

public class Question6 {
    // https://www.acmicpc.net/problem/20300
    // 복습 하긴 했지만 틀린점을 못찼겠음.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);
        long max = 0;
        if (N % 2 != 0) {
            max = arr[N - 1];
        } else {
            for (int i = 0; i < N; i++) max = Math.max(max, arr[i] + arr[N - i - 1]);
        }

        System.out.print(max);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String[] str = br.readLine().split(" ");
//
//        long[] arr = Arrays.stream(str).mapToLong(Long::parseLong).toArray();
//        Arrays.sort(arr);
//
//        long max = 0;
//        if (n % 2 != 0) {
//            max = arr[n - 1];
//            n -= 1;
//        }
//
//        for (int i = 0; i < n / 2; i++) {
//            max = Math.max(max, arr[i] + arr[n - 1 - i]);
//        }
//
//        System.out.println(max);
//    }
}