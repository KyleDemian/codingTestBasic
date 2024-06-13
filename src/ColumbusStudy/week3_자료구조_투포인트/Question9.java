package ColumbusStudy.week3_자료구조_투포인트;

import java.util.*;
import java.io.*;

public class Question9 {

    // https://www.acmicpc.net/problem/1940
    // 복습 완료
    // 정렬 후 투포인트 알고리즘을 사용한 문제

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;
        int total = 0;

        while(lt < rt){
            int sum = arr[lt] + arr[rt];
            if(m == sum){
                total++;
                lt++;
                rt--;
            } else if(sum < m){
                lt++;
            } else if(sum > m){
                rt--;
            }
        }

        System.out.print(total);
    }
}