package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] value = br.readLine().split(" ");
        int n = Integer.parseInt(value[0]);
        int m = Integer.parseInt(value[1]);
        StringBuilder sb = new StringBuilder();

        boolean[] checked = new boolean[m + 1];

        for (int i = 2; i <= m; i++) {
            if (!checked[i]) {
                for (int j = i; j <= m; j+= i) {
                    checked[j] = true;
                }

                if (i >= n) {
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
