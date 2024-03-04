package day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Question1 {

    // https://cote.inflearn.com/contest/10/problem/04-01

    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // 필수!
        }
        // A 3, B 3, C 5, D 2, E 2

        int max = 0;
        for (char key : map.keySet()) {     // Key를 탐색하는 함수.
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question1 T = new Question1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        // 같은 문자 가장 많이 나온것 출력
        // 15
        // BACBACCACCBDEDE
        System.out.println(T.solution(n, str));
    }
}
