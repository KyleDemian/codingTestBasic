package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question11 {

    // https://www.acmicpc.net/problem/22864

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int m = Integer.parseInt(input[3]);

        int sum = 0;
        int tired = 0;
        for (int i = 0; i < 24; i++) {
            if (tired + a <= m) {
                sum += b;
                tired += a;
            } else {
                tired = Math.max(0, tired - c);
            }
        }

        System.out.print(sum);
    }
}
