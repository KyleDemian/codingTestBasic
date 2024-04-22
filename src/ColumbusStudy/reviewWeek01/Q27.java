package ColumbusStudy.reviewWeek01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q27 {
    public static void main (String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int answer = 0;

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int x : arr) {
            answer += m / x; // 몫 동전 개수
            m %= x; // 나머지 금액
        }

        System.out.println(answer);
    }
}
