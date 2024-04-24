package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question6 {

    // https://www.acmicpc.net/problem/2231
    // 분해합
    // 숫자를 216을 받으면 해당 숫자 값을 만들 수있는 값을 찾으면 됌 없다면, 0
    // ex ) 216의 경우 198일때 해당 각자리의 합 1 + 9 + 8 + 198 = 216 이므로 분해합 됌
    // 즉 N 까지의 숫자까지 올라가면서 해당 숫자가 값이 같은지 체크하면 끝
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 1; i <= n; i++) {
            int number = i;
            int res = 0;

            while (number > 0) {
                res += number % 10;
                number /= 10;
            }

            if ((res + i) == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
