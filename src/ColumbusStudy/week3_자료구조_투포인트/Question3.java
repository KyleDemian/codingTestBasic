package ColumbusStudy.week3_자료구조_투포인트;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question3 {

    // https://www.acmicpc.net/problem/1021
    // 복습 완료

    static Deque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();   // Queue Size
        int m = kb.nextInt();   // 뽑아 내려가 하는 수의 개수
        int answer = 0;

        // 덱큐에 다 쌓고나서
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        // dq.offerFirst(1);
        // dq.offerLast(1);
        // dq.pollFirst();
        // dq.pollLast();

        for (int i = 0; i < m; i++) {
            // 입력 값
            int a = kb.nextInt();
            int index = 0;

            for (Integer num : dq) {
                index++;
                if (num == a) {
                    break;
                }
            }

            // 나서 dqStart = index - 1;는 a까지 왼쪽 방향으로의 거리를 나타내고, dqEnd = dq.size() - index;는 a까지 오른쪽 방향으로의 거리를 나타냅니다.
            //예를 들어, 큐가 1 2 3 4 5 6 7 8 9 10 과 같이 되어 있고, a가 4라면 index는 4가 됩니다. 따라서 dqStart는 3 (왼쪽으로 3칸 움직이면 a에 도달)이 되고, dqEnd는 10 - 4 = 6 (오른쪽으로 6칸 움직이면 a에 도달)이 됩니다.
            int dqStart = index - 1;        // 왼쪽으로부터
            int dqEnd = dq.size() - index;  // 오른쪽으로부터

            // 덱의 왼쪽 끝에서 a까지의 거리 (index - 1)와 오른쪽 끝에서 a까지의 거리 (dq.size() - index)를 계산합니다.
            // 더 짧은 거리를 선택한 후 요소 a를 큐의 첫 부분으로 이동시키기 위해 해당 방향으로 큐를 회전합니다.
            while(true){
                if (a == dq.peekFirst()) {
                    dq.pollFirst();
                    break;
                } else {
                    if( dqStart <= dqEnd){   // 좌측
                        for(int j = 0; j < dqStart; j++) {
                            dq.offerLast(dq.pollFirst());
                            answer++;
                            if (a == dq.peekFirst()) break;
                        }
                    } else { // 우측
                        for(int j = 0; j < dq.size() - index + 1; j++) {
                            dq.offerFirst(dq.pollLast());
                            answer++;
                            if (a == dq.peekFirst()) break;
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
