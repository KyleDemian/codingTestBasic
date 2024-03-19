package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time3 implements Comparable<Time3> {
    public int time;
    public char state;

    public Time3(int time, char state) {
        this.time = time;
        this.state = state;
    }


    @Override
    public int compareTo(Time3 o) {
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
public class Question3 {
    public int solution(ArrayList<Time3> arr) {
        int answer = 0;
        Collections.sort(arr);
        int cnt = 0;    // 현재 존재하는 사람들
        for (Time3 ob : arr) {
            if(ob.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Question3 q = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time3> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Time3(x, 's'));
            arr.add(new Time3(y, 'e'));
        }
        System.out.println(q.solution(arr));
    }
}
