package day10;

import java.util.Arrays;
import java.util.Scanner;

public class Question6 {

    public static void main(String[] args) {
        Question6 q = new Question6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int ps = kb.nextInt();
            int pt = kb.nextInt();
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);
            }
        }
        System.out.println(dy[m]);

        // 최대점수 구하기 ( 냅색 알고리즘 )
        // 시간안에 얻을 수 있는 최대 점수를 출력
        // 5문제 20분주짐 > 일단 해결하기 위해서 하나 기준으로 정렬할것 Implements Comparable
        // 앞에께 점수 뒤에께 시간
        // 한문제는 단 한번만 풀 수있고, 중복되면 안됌. ( 그래서 J를 역순으로 돌려야함 )
        // 무한정이라면 순방향, 그게아니면 역방향 asc , desc
        // 5 20
        // 10 5
        // 25 12
        // 15 8
        // 6 3
        // 7 4
    }
}
