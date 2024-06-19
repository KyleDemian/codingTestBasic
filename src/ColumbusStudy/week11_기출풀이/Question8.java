package ColumbusStudy.week11_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question8 {

    // https://www.acmicpc.net/problem/12933
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[6];
        int mx = 0;
        arr[0] = str.length();
        for (int i = 0; i < str.length(); i++) {
            int n = 0;
            if (str.charAt(i) == 'q') n = 1;
            if (str.charAt(i) == 'u') n = 2;
            if (str.charAt(i) == 'a') n = 3;
            if (str.charAt(i) == 'c') n = 4;
            if (str.charAt(i) == 'k') n = 5;
            if (arr[n - 1] == 0) {
                System.out.println("-1");
                return;
            }
            arr[n]++;
            arr[n - 1]--;
            mx = Math.max(mx, arr[1] + arr[2] + arr[3] + arr[4]);
        }
        if (arr[5] * 5 != str.length()) {
            System.out.println("-1");
            return;
        }
        System.out.println(mx);
    }
}
