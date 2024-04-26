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

        profit(0, 0);
        System.out.println(max);
    }

    public static void profit(int day, int profit) {
        if(day == n){
            max = Math.max(max, profit);
            return;
        }
        if(day + t[day] <= n) profit(day + t[day], profit + p[day]); // 상담을 수행하는 경우
        profit(day + 1, profit); // 상담을 수행하지 않는 경우
    }
    // 결국에는 이진트리로 생각해서 접근해야함.
    // 현재 날짜의 상담을 수행하는 경우:
    // 이 경우에는 day은 상담 기간인 t[day]를 더한 값이며,
    // profit은 상담료인 p[day]를 더한 값이 됩니다.
    // 이때 이 수행이 가능한지는 상담이 끝나는 날짜인 day + t[day]가 전체 기간 n을 넘지 않는지 확인해야 합니다.

    // 현재 날짜의 상담을 수행하지 않는 경우:
    // 일을 수행하지 않으므로 day만 다음 날로 넘어가고, profit은 그대로입니다.
}
