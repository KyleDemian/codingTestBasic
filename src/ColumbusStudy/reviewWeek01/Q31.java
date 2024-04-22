package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q31 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] kms = br.readLine().split(" ");
        String[] prices = br.readLine().split(" ");

        int[] km = Arrays.stream(kms).mapToInt(Integer::parseInt).toArray();
        int[] point = Arrays.stream(kms).mapToInt(Integer::parseInt).toArray();

        long sum = 0;
        long minPrice = point[0];

        for (int i = 0; i < n; i++) {
            if (point[i] < minPrice) {
                minPrice = point[i];
            }
            sum += (long) km[i] * minPrice;
        }

        System.out.println(sum);
    }
}
