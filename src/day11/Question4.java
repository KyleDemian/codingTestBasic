package day11;

import java.io.IOException;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) throws IOException {
        Question4 q = new Question4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(q.solution( n));
        }

        // 피자 조각
        public int solution(int n) {
            return lcm(n, 6) / 6;
        }

        private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
