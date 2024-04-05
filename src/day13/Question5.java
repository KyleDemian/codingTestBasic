package day13;

import java.util.Scanner;

public class Question5 {

    // https://www.acmicpc.net/problem/14607
    // 틀림.. 답이 모지
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        long n = kb.nextLong();
        long result = 0;

        result = (n / 3) * 2;
        if (n % 3 != 0) {
            result += 1;
        }

        System.out.println(result);
    }
}
