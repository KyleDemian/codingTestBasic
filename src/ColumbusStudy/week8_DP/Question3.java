package ColumbusStudy.week8_DP;

import java.util.Scanner;

public class Question3 {

    // https://www.acmicpc.net/problem/9095
    // 복습 완료
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dp = new int[12];
        dp[1] = 1;  // 1 일경우 1,2,3 으로 만들수 잇는 숫자는 1개,
        dp[2] = 2;  // 2 일경우 만들 수 있는 숫자가 2개
        dp[3] = 4;
        dp[4] = 7;  // 즉 3 + 2 + 1 = > 7 이 나옴. 그 다음케이스도 동일하게 넘어갈거임..

        // 해당 문제는 4번째의 경우 1, 2, 3 을 합한 가지수가 나온다는거임,  5번의 경우 4 3 2 의 합
        for (int i = 5; i <= 11 ; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
