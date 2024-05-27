package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question7 {

    // https://www.acmicpc.net/problem/2839
    // https://st-lab.tistory.com/72
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 4 || n == 7) {
            System.out.println(-1);
        } else if (n % 5 % 2 == 0) {
            System.out.println(n / 5 + n % 5 / 3);
        } else {
            System.out.println((n / 5 - 1) + (n % 5 + 5) / 3);
        }

        // if( n == 4 || n == 7) System.out.println(-1);
        // else if( n % 5 == 0 ) System.out.println(n/5);
        // else if( n % 5 == 1 || n % 5 == 3 ) System.out.println((n/5) + 1);
        // else if( n % 5 == 2 || n % 5 == 4 ) System.out.println((n/5) + 2);
    }
}
