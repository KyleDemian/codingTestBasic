package ColumbusStudy.week1;

import java.util.Scanner;

public class Question1 {

    // https://www.acmicpc.net/submit/11720/75182713
    // N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
    public static void main(String[] args) {
        Scanner kb =  new Scanner(System.in);
        int cnt = kb.nextInt();
        String value = kb.next();
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += value.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}
