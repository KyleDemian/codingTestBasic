package day12;

import java.util.HashMap;
import java.util.Scanner;

public class Question7 {

    // https://www.acmicpc.net/problem/6996
    // 아나그램

    public String solution(String a, String b) {
        String answer = a + " & " + b +" are ";
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for (char x : a.toCharArray()) {
            am.put(x, am.getOrDefault(x, 0) + 1);
        }

        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        if (am.equals(bm)) {
            answer += "anagrams.";
        }else {
            answer += "NOT anagrams.";
        }

        return answer;
    }


    public static void main(String[] args) {
        Question7 T = new Question7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for (int i = 0; i < n; i++) {
            String a = kb.next();
            String b = kb.next();

            System.out.println(T.solution(a ,b));
        }

        // 모든 아나그램 찾기, 2포인트, 해쉬, 슬라이딩 윈도우
        // 3
        // blather reblath
        // maryland landam
        // bizarre brazier

    }
}
