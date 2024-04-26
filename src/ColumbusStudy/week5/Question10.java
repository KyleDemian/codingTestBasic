package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10 {

    // https://www.acmicpc.net/problem/17626
    // https://comain.tistory.com/306 참고 사이트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            // 모든 숫자 값은 1*1 이 될수가 잇기때문에 해당 값으로 만들고,
            dp[i] = i;
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}

/*
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            // 현재 구할 값의 개수는 전 값의 +1이니 전 값을 그대로 우선 가져온다.
            dp[i] = dp[i - 1];
            // 25. j는 1~5까지 올 수 있다.
            //j가 1일때 25 - 1*1 = 24. 24의 개수는 3이다.
            //j가 2일때 25 - 2*2 = 21. 21의 개수는 3이다.
            //j가 3일때 25 - 3*3 = 16. 16의 개수는 1이다.
            //j가 4일때 25 - 4*4 = 9. 9의 개수는 1이다.
            //j가 5일때 25 - 5*5 = 0. 0의 개수는 0이다.
            for(int j = 1; j * j <= i; j++) {
                //현재 들어가있는 값과, i - j * j의 값과 비교해서 작은 값을 다시 저장
                dp[i] = Math.min(dp[i], dp[i - (j * j)]);
            }
            //최솟값이 저장되었을테니 +1을 해서 마무리 해준다.
            dp[i]++;
        }
        System.out.println(dp[n]);
* */
