package day13;

import java.util.Scanner;

public class Question2 {

    // https://www.acmicpc.net/problem/2443

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = kb.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }

            for (int j = 1; j <= 2 * (n - i) - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
