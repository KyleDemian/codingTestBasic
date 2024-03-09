package day7;

import java.util.Scanner;

public class Question1 {

    // https://cote.inflearn.com/contest/10/problem/07-01

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            //스택 프레임을 사용하기 때문에 이러현 현상이 발상되는거임.  ( 매개변수/ 지역변수 / 복귀주소 )
            // 3 2 1    // 선처리
            System.out.println(n + " ");
            DFS(n-1);
            // 1 2 3    // 후처리
            System.out.println(n + " ");
        }
    }

    public static void main(String[] args) {
        Question1 T = new Question1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        // 재귀 함수 - 자기 자신 1개만 호출 받음 ( DFS Or Recursive)
        // 3
        T.DFS(n);
    }
}
