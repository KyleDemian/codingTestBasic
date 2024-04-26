package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question13 {
    // https://www.acmicpc.net/problem/14501

    static int n, max = 0;
    static int[] t, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        getMaxProfit(0, 0);
        System.out.println(max);
    }

    public static void getMaxProfit(int day, int profit) {
        if(day == n){
            max = Math.max(max, profit);
            return;
        }
        if(day + t[day] <= n) getMaxProfit(day + t[day], profit + p[day]); // 상담을 수행하는 경우
        getMaxProfit(day + 1, profit); // 상담을 수행하지 않는 경우
    }
}
