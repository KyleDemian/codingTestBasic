package ColumbusStudy.week9_다익스트라;

import java.io.*;
import java.util.*;

public class Question5 {

    // https://www.acmicpc.net/problem/1927 (필수)
    // 최소 힙
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            // 입력에서 0이 주어진 횟수만큼 답을 출력한다.
            // 만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다.
            if( a > 0 ) pq.offer(a);
            else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
