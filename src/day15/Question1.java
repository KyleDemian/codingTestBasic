package day15;

import java.util.Scanner;

public class Question1 {

    // https://www.acmicpc.net/problem/2738
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = kb.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                b[i][j] = kb.nextInt();
            }
        }

        int[][] c = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
