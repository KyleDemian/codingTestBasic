package day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Question4 {

    // https://cote.inflearn.com/contest/10/problem/04-04

    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        // 사전 세팅
        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }
        int L = b.length() - 1;
        for (int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        // 투포인트 알고리즘, 슬라이딩 윈도우, 아나그램 알고리즘 equals
        int lt = 0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) {
                answer++;
            }
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }
            lt++;
        }


        return answer;
    }


    public static void main(String[] args) {
        Question4 T = new Question4();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();

        // 모든 아나그램 찾기, 2포인트, 해쉬, 슬라이딩 윈도우
        // bacaAacba
        // abc
        System.out.println(T.solution(a ,b));
    }
}
