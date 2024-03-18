package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body> {
    public int h,w;

    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override // 내림차순정렬됌
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}

public class Question1 {

    // 좌표정렬을 다시 확인하고 문제를 풀어야함.
    // 그리디 현재 시점에서 최선의 선택을 하는것.
    // 어떠한 기준을 정렬해두고 다른한쪽을 선택해나가는 방법이 그리디
    // 최대값을 계속 선정하면 됌

    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for (Body ob : arr) {
            if (ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Question1 q = new Question1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new Body(h, w));
        }

        System.out.println(q.solution(arr, n));

        //5
        // 172 67
        // 183 65
        // 180 70
        // 170 72
        // 181 60
    }
}
