package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1 {

    // https://www.acmicpc.net/problem/10870
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 오답 이유, n 값이 0 또는 1, 2 일때의 경우를 생각하지 않았음.
        int a = 1, b = 1, c = 0;
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1 || n == 2) {
            System.out.println(1);
        } else {
            for (int i = 2; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(c);
        }
    }
}
