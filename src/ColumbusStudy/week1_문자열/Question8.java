package ColumbusStudy.week1_문자열;

import java.math.BigInteger;
import java.util.Scanner;

public class Question8 {

    // https://www.acmicpc.net/problem/1373
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        // 2 진수 값을 10 진수로 -> 10진수를 다시 8진수로 변경
        BigInteger num = new BigInteger(n.trim(), 2);
        System.out.println(num.toString(8));

        // 제곱관련한 부분은 특별한 관계가 생김 2 4 8 16 etc..
        // 1111 -> 17
        // 111 -> 7
        // 11 -> 3
        // 1 -> 1

        // String binary = Integer.toBinaryString(num);    // 2 진수
        // String octal = Integer.toOctalString(num);      // 8 진수
        // String hexadecimal = Integer.toHexString(num);  // 16 진수
    }
}
