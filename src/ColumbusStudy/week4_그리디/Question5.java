package ColumbusStudy.week4_그리디;

import java.io.*;
import java.util.*;

public class Question5 {

    // https://www.acmicpc.net/problem/13305
    // 복습 완 > 결과값을 무조건 Long 으로 선언해야 제대로 나오네

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점의 개수
        int n = Integer.parseInt(br.readLine());

        int[] km = new int[n-1];
        int[] cost = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < km.length; i++) km[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < cost.length; i++) cost[i] = Integer.parseInt(st.nextToken());

        long sum = 0;
        long minCost = cost[0];

        for(int i = 0; i < n - 1 ; i++){
            if(cost[i] < minCost){
                minCost = cost[i];
            }
            sum += km[i] * minCost;
        }

        System.out.print(sum);
    }
}
