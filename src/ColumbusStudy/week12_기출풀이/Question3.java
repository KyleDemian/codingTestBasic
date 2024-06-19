package ColumbusStudy.week12_기출풀이;

import java.util.*;
import java.io.*;

public class Question3 {

    // https://www.acmicpc.net/problem/2138

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String start = br.readLine();
        String end = br.readLine();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(String.valueOf(start.charAt(i)));
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(String.valueOf(end.charAt(i)));

        int[] c = Arrays.copyOf(a, n);  // c는 1번 스위치를 누른 경우이다.
        c[0] = 1 - c[0];
        c[1] = 1 - c[1];

        int answer = solve(n, a, b);    // 1번 스위치 안누른 경우에 대해 진행
        int answer2 = solve(n, c, b);	// 1번 스위치 누른 경우에 대해 진행
        if (answer2 != -1) answer2++;

        if (answer == -1) System.out.println(answer2);
        else if (answer2 == -1) System.out.println(answer);
        else System.out.println(Math.min(answer2, answer));
    }

    static int solve(int n, int[] a, int[] b) {
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != b[i]) {
                cnt++;
                a[i] = 1 - a[i];
                a[i + 1] = 1 - a[i + 1];
                if (i != n - 2)
                    a[i + 2] = 1 - a[i + 2];
            }
        }

        return a[n - 1] != b[n - 1] ? -1 : cnt;

    }
}
