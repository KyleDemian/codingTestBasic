package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question7 {

    // https://www.acmicpc.net/problem/18312
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        // 시각
        int n = Integer.parseInt(str[0]);
        String k = str[1];
        int sum = 0;

        // i 시 j 분 l 초
        // 틀린 이유 : 숫자 0을 배제해버렸음..
        for (int i = 0; i <= n; i++){
            for (int j = 0; j < 60; j++) {
                for (int l = 0; l < 60; l++) {
                    String h = (i < 10) ? "0" + i : i + "";
                    String m = (j < 10) ? "0" + j : j + "";
                    String s = (l < 10) ? "0" + l : l + "";
                    if (h.contains(k) || m.contains(k) || s.contains(k)) {
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
