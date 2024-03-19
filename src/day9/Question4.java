package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;

    public Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}
public class Question4 {

    static int n, max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr); // 날짜 기준 역순
        int j=0;
        for (int i = max; i >= 1; i--) {    // 가장 큰거 기준이니까 가장 큰것부터 적은걸로
            for ( ; j < n; j++ ) {
                if(arr.get(j).date < i) break;
                pq.offer(arr.get(j).money);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Question4 q = new Question4();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) max = d;
        }

        System.out.println(q.solution(arr));

        // 최대수입스케줄 (우선순위 큐)
        // 가장 작은값 Or 가장 큰값을 정해서 시작을 함. offer, poll 넣기, 빼기
        // 6
        // 50 2
        // 20 1
        // 40 2
        // 60 3
        // 30 3
        // 30 1
    }
}
