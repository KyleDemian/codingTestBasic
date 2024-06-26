package ColumbusStudy.week3_자료구조_투포인트;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Question7 {

    // https://www.acmicpc.net/problem/2164
    // 복습 완
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        // 담을 곳 생성
        Deque<Integer> dq = new LinkedList<>();

        // 쌓인값 넣기
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        while(dq.size() > 1){
            // 첫번째 카드 버리기
            dq.pollFirst();

            // 마지막 카드 넣기
            if (dq.size() > 1) {
                dq.offerLast(dq.pollFirst());
            }
        }

        System.out.println(dq.peekFirst());
    }
}


