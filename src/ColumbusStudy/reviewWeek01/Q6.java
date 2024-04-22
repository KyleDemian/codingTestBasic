package ColumbusStudy.reviewWeek01;

import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int gcd = gcd(n, m);
        int lcm = lcm(n, m);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return gcd(m, n % m);
        }
    }

    static int lcm(int n, int m) {
        return (n * m) / gcd(n, m);
    }
}
