package day6;

import java.util.*;

public class Question7 {

    // https://cote.inflearn.com/contest/10/problem/06-07
    // 알고리즘 배우기
    static class Point implements Comparable<Point> {
        public int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y-o.y;  // 오름차순 // this 가 앞에 있으면, 오름차순, 다른 객체가 먼저 있으면 내림차순 // 음수값이 리턴되게하면 음수!
            }else {
                return this.x-o.x;
            }
        }
    }

    public static void main(String[] args) {
        Question7 T = new Question7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        ArrayList<Point> arr = new ArrayList<Point>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();

            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for (Point o : arr) {
            System.out.println(o.x + " " + o.y);
        }
        // 좌표 정렬
        // 5
        // 2 7
        // 1 3
        // 1 2
        // 2 5
        // 3 6
    }
}
