package day15;

import java.util.Scanner;

public class Question4 {

    // https://www.acmicpc.net/problem/10813
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        kb.nextLine();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
