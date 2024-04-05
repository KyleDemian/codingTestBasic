package ColumbusStudy.week3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question7 {

    // https://www.acmicpc.net/problem/2164
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
            // 틀린 이유 해당 카드가 두장남았을때 맨 위의 카드를 옮기는 동작을 수행하지 말아야 하는데 해당 동작을 수행함
            //  dq.offerLast(dq.pollFirst());
            //  if (dq.size() == 1) {
            //      break;
            //  }
            if (dq.size() > 1) {
                dq.offerLast(dq.pollFirst());
            }
        }

        System.out.println(dq.peekFirst());
    }
}
