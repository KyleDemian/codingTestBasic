package ColumbusStudy.week3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Question3 {

    // 중간고사 문제였음.. 아놔.. 어려웠다. 왜 푼기억이랑 이해가 안되나했는데..
    // https://www.acmicpc.net/problem/1021
    // https://infodon.tistory.com/89 참고 사이트
    // https://st-lab.tistory.com/216
    // https://st-lab.tistory.com/187

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

            // 방향 전환을 위해서 알아야할 최소값
            // 변환은 성능 저하를 일으킬 수도 있습니다. Integer를 int로 자동 변환하는 과정에서는
            // 내부적으로 Integer.intValue() 메서드를 호출하게 되며, 이는 추가적인 연산을 필요로 합니다.
            // 하지만 이런 점은 일반적으로 크리티컬한 성능 이슈를 일으키지는 않습니다.
            // 따라서 실제로 어떤 타입을 사용할지는 특정 상황과 요구 사항에 따라 판단하시면 됩니다.
            // 일반적으로 Integer가 필요할 때는 그대로 사용하며, 기본 타입인 int를 사용해야 할 때는 Unboxing을 통해 사용하면 됩니다.
            for (Integer num : dq) {
                index++;
                if (num == a) {
                    break;
                }
            }

            int dqStart = index - 1;        // 왼쪽
            int dqEnd = dq.size() - index;  // 오른쪽

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

//            while(true){
//                if (a == dq.peekFirst()) {
//                    dq.pollFirst();
//                    break;
//                } else {
//                    if( index - 1 <= dq.size() - index){   // 좌측
//                        dq.offerLast(dq.pollFirst());
//                        answer++;
//                    } else { // 우측
//                        dq.offerFirst(dq.pollLast());
//                        answer++;
//                    }
//                }
//            }
        }
        System.out.print(answer);
    }
}
