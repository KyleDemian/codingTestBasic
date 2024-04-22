package ColumbusStudy.reviewWeek01;

import java.math.BigInteger;
import java.util.Scanner;

public class Q8 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String n = kb.next();

        String.valueOf(123545);
        BigInteger num = new BigInteger(n, 2);
        System.out.println(num.toString());
        System.out.println(num.toString(8));
    }
}
