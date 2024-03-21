package ColumbusStudy.week1;

import java.util.Scanner;

public class Question1 {

    // https://www.acmicpc.net/problem/11720
    // N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

    // 캐릭터 클래스와 인티저의 차이 // 표현범위가 다름
    // 인티저 음의 정수 -> 차는 음의 정수가 불가능함 // 사인드 //언사인드 
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
