package ColumbusStudy.week4_그리디;

import java.util.*;
import java.io.*;
public class Question1 {

    // https://www.acmicpc.net/problem/11047
    // 복습 완료
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int answer = 0;
        for(int i = N-1; i >= 0 ; i--){
            answer += K / arr[i];
            K %= arr[i];
        }

        System.out.print(answer);
    }
}
