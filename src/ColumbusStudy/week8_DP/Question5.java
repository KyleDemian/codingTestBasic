package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question5 {

    // https://www.acmicpc.net/problem/9655
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 1000 개까지,

        // x : 상근, y : 창영 -> 시작은 무조건 상근
        System.out.print((n % 2 != 0) ? "SK" : "CY");
    }
}
