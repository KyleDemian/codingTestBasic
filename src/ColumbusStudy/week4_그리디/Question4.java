package ColumbusStudy.week4_그리디;

import java.io.*;
import java.util.*;

public class Question4 {

    // https://www.acmicpc.net/problem/20115
    // 복습 완

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        // 첫번째는 가장 큰걸 들고 있고, 그 이후부터 반씩 나눠담음.
        double answer = arr[n-1];
        for(int i = n-2 ; i >=0; i--){
            answer += (arr[i] / 2.0);
        }

        System.out.printf("%.2f", answer);
    }
}
