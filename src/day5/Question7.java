package day5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question7 {

    // https://cote.inflearn.com/contest/10/problem/05-07 queue

    public String solution(String need ,String plan) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        // 필수 과목을 순서대로 삽입 CBA
        for (char x : need.toCharArray()) {
            q.offer(x);
        }

        for (char x : plan.toCharArray()) {
            if (q.contains(x)) {
                if (x != q.poll()) {
                    return "NO";
                }
            }
        }

        if (!q.isEmpty()) {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Question7 T = new Question7();
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        String m = kb.next();

        // 교육과정 설계 문제 - 해당과목을 순서대로 들었는지 안들었는지 확인
        // CBA
        // CBDAGE
        System.out.println(T.solution(n, m));
    }
}
