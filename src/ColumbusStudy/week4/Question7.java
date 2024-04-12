package ColumbusStudy.week4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question7 {

    //https://www.acmicpc.net/problem/1541

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        int sum = 0;

        String[] sub = str.split("-");

        // 음수 전의 합계
        sum = calculateSum(sub[0]);

        for (int i = 1; i < sub.length; i++) {
            // 음수 전의 합계에서 ( ) 안의 수를 합산해서 빼기 ( 이건 음수가 한개일때만 가능 )
            sum -= calculateSum(sub[i]);
        }

        System.out.println(sum);
    }

    private static int calculateSum(String sub) {
        String[] number = sub.split("\\+");
        int sum = 0;

        for (String num : number) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
