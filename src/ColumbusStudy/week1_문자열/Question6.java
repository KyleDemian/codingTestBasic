package ColumbusStudy.week1_문자열;

import java.util.Scanner;

public class Question6 {

    // https://www.acmicpc.net/problem/2609
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int gcd = findGcd(n, m);
        int lcm = findLcm(n, m);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 최소공배수 -> 최대공약수를 호출해서 구함.
    static int findLcm(int n, int m)     {
        return (n * m) / findGcd(n, m);
    }

    // https://seunghyum.github.io/algorithm/Euclidean-algorithm/# // 유클리디안 알고리즘
    static int findGcd(int n, int m) {
        if (m == 0){
            return n;
        } else {
            return findGcd(m, n % m);
        }
    }
}
