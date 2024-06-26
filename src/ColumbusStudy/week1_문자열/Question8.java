package ColumbusStudy.week1_문자열;

import java.math.BigInteger;
import java.io.*;

public class Question8 {

    // https://www.acmicpc.net/problem/1373
    // 복습 완
    // import java.math.BigInteger; << 필수.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(br.readLine(), 2);
        System.out.print(num.toString(8));

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
