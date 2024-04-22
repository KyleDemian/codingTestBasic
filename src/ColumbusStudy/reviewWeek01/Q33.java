package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q33 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int sum = 0;

        String[] s = str.split("-");

        sum = Integer.parseInt(s[0]);

        for(int i = 1; i < s.length; i++) {
            sum -= cal(s[i]);
        }

        System.out.println(sum);
    }

    static int cal(String s) {
        String[] a = s.split("\\+");
        int sum = 0;

        for (String qq : a) {
            sum += Integer.parseInt(qq);
        }

        return sum;
    }
}
