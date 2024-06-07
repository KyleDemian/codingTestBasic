package ColumbusStudy.week2_스택_큐;

import java.io.IOException;
import java.util.*;

public class Question7 {
    // https://www.acmicpc.net/problem/1158
    // 복습 완
    // 요세푸스 문제
    // 둥글게 앉아있다고 생각하고, K 번째마다 빼버리면 됌
    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int n = kb.nextInt();
        // 1 to 7
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int k = kb.nextInt();
        sb.append("<");
        // K 번째까지 그럼 ...?
        while (q.size() > 1) {
            // 현재 1 부터 n 명까지 뽑아내는 거
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
