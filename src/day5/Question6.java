package day5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Question6 {

    // https://cote.inflearn.com/contest/10/problem/05-06 queue

    public int solution(int n ,int m) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        // 8명 셋팅
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 1; i < m; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question6 T = new Question6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        // 공주 구하기문제 FIFO QUEUE
        // m= 3일때 2명을 앞에 빼고 다시 삽입, 한명을 Poll
        // 8 3
        // 7
        System.out.println(T.solution(n, m));
    }
}
