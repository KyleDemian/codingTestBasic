package day13;

import java.math.BigInteger;
import java.util.Scanner;

public class Question3 {

    // https://www.acmicpc.net/problem/1081
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        long a = kb.nextLong();
        long b = kb.nextLong();

        long sum = 0;

        for (long i = a; i <= b; i++) {
            sum += digit(i);
        }

        System.out.println(sum);
    }

    private static long digit(long i) {
        long sum = 0;
        // num % 10: 이 연산은 num에서 가장 낮은 자리의 수(일의 자리)를 반환합니다.
        // 예를 들어, 숫자 123은 3을, 숫자 45는 5를 의미합니다. 이 결과가 sum 변수에 더해집니다.
        // num /= 10: 이 연산은 num을 10으로 나눕니다. 이는 기본적으로 정수 나눗셈이기 때문에 소수점 이하는 절사됩니다.
        // 이 연산의 결과는 num의 가장 낮은 자리수가 제거되는 것입니다. 예를 들어, 숫자 123은 12로 변하고, 45는 4로 변합니다.
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
