package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question5 {

    // https://www.acmicpc.net/problem/10811

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        ArrayList<Integer> baskets = new ArrayList<Integer>();
        for(int i = 0; i <= N; i++) {
            baskets.add(i);
        }

        for(int i = 0; i < M; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            Collections.reverse(baskets.subList(s, e + 1));
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(baskets.get(i) + " ");
        }
    }
}
