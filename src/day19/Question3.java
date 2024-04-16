package day19;

import java.util.Scanner;

public class Question3 {

    // https://www.acmicpc.net/problem/10871
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int x = kb.nextInt();
        kb.nextLine();
        String[] a = kb.nextLine().split(" ");
        String answer = "";

        for(int i = 0; i < n; i++){
            if (Integer.parseInt(a[i]) < x) {
                answer += a[i] + " ";
            }
        }

        System.out.print(answer);
    }
}
