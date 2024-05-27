package ColumbusStudy.week3_자료구조_투포인트;

import java.util.Scanner;

public class Question1 {

    // https://www.acmicpc.net/problem/2960
    // 2, 4, 6, 8, 10, 3, 9, 5, 7 순서대로 지워진다. 7번째 지워진 수는 9이다.
    // 모든 숫자를 체크 해야만 함 건너 뛰면 안됌!!

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        // 체크할 배열 만듦 && 체크할것 만듦 +1 +1 K == 같을때까지 //
        boolean arr[] = new boolean[n+1];
        int checked = 0;
        int savedNumber = 0;

        // 에라토스테네스의 체 의 시작
        for (int i = 2; i <= n; i++) {
            for(int j = i; j <= n ; j+=i ){
                // 모든 숫자값을 검사를 해야 하므로 하나씩 다 체크해야함...
                if (!arr[j]) {
                    arr[j] = true;
                    checked++;

                    if(checked == k){
                        savedNumber = j;
                        break;
                    }
                }
            }
            if(checked == k) break;
        }

        System.out.print(savedNumber);
    }
}
