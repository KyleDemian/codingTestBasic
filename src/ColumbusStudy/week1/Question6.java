package ColumbusStudy.week1;

import java.util.Scanner;

public class Question6 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int gcd = findGcm(n, m);
        int lcm = findLcm(n, m);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int findLcm(int n, int m) {
        return (n * m) / findGcm(n, m);
    }

    static int findGcm(int n, int m) {
        if (m == 0){
            return n;
        } else {
            return findGcm(m, n % m);
        }
    }
}
