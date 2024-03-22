package ColumbusStudy.week1;

import java.math.BigInteger;
import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        // 2 진수 값을 10 진수로 -> 10진수를 다시 8진수로 변경
        BigInteger num = new BigInteger(n.trim(), 2);
        System.out.println(num.toString(8));
    }
}
