package day5;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question8 {

    // https://cote.inflearn.com/contest/10/problem/05-08 queue

    class Person{
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public int solution(int n ,int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i])); // 인스턴스변수로 순서값과, 위험도를 담고 시작.
        }

        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for (Person x : q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Question8 T = new Question8();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 응급실  // M번째 환자의 몇 번째로 진료받는지 출력하세요. ( 단, 위험도가 낮을경우 맨 뒤로감 )
        // 5 2
        // 60 50 70 80 90
        System.out.println(T.solution(n, m, arr));
    }
}
