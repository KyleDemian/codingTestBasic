package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q32 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long max = 0;
        if (n % 2 != 0) {
            max = arr[n/2];
            n -= -1;
        }

        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] + arr[n - i - 1]);
        }

        System.out.println(max);
    }
}
