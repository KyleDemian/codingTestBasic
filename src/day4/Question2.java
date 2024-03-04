package day4;

import java.util.HashMap;
import java.util.Scanner;

public class Question2 {

    // https://cote.inflearn.com/contest/10/problem/04-02

    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        // 첫번째 맵
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 두번째 맵 -> 1에 등록된거랑 비교, 동일한게 있으면 갯수 -1 씩 차감 // 감소시킬께 없다면 NO
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x)==0) {
                return "NO";
            }
            map.put(x, map.get(x)-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Question2 T = new Question2();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();

        // 아나그램 ( 해쉬 ) -> 순서 상관없이, 구성요소가 동일한지 확인
        // baeeACA
        // AbaAeCe
        System.out.print(T.solution(a, b));
    }
}
