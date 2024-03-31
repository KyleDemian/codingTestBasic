package day12;

import java.util.Arrays;
import java.util.HashMap;

public class Question5 {

    // 한번만 등장하는 문자 찾기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120896
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char x : s.toCharArray()) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        // 결국에는 한번만 노출되는 문자를 여기다가 저장
        hm.forEach((key, value) -> {
            if (value == 1) {
                sb.append(key);
            }
        });

        // 정렬
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);

        answer = new String(arr);

        return answer;
    }
}
