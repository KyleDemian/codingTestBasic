package day10;

import java.util.*;

class Brick implements Comparable<Brick> {
    public int s,h, w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}
public class Question4 {
    // 동적계획법!
    static int[] dy;

    public int solution(ArrayList<Brick> arr) {
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        int answer = dy[0];
        for (int i = 1; i < arr.size(); i++) {
            int max_h= 0;
            for (int j = i-1; j >= 0 ; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Question4 q = new Question4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Brick(a, b, c));
        }
        // 최대 증가 수열
        // 5
        // 25 3 4
        // 4 4 6
        // 9 2 3
        // 16 2 5
        // 1 5 2
        System.out.println(q.solution(arr));

    }
}
