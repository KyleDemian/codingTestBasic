package ColumbusStudy.week4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        int answer = 0;

        // 동전 종류
        Integer[] coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = kb.nextInt();
        }

        // 가장 큰값 부터
        Arrays.sort(coin, Collections.reverseOrder());

        for (int x : coin) {
            answer += k / x;
            k %= x;
        }

        System.out.println(answer);
    }
}
