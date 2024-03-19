package day9;

import java.util.*;

class Time implements Comparable<Time> {
    public int s, e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.e == o.e){
            return this.s - o.s;
        } else return this.e - o.e;
    }
}

public class Question2 {
    public int solution(ArrayList<Time> arr, int n) {
        int answer = 0;

        Collections.sort(arr);
        int et = 0;
        for (Time ob : arr) {
            if (ob.s >= et) {
                answer++;
                et = ob.e;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Time(x, y));
        }
        System.out.println(q.solution(arr, n));
    }
}
