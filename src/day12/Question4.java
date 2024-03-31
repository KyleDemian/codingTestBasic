package day12;

import java.util.HashMap;
import java.util.Map;

public class Question4 {

    // 모스부호
    // https://school.programmers.co.kr/learn/courses/30/lessons/120838
    public String solution(String letter) {
        String answer = "";
        String[] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String, Character> toEnglish = new HashMap<>();
        // 영어 소문자 만듦기.
        for (int i = 0; i < str.length; i++) {
            toEnglish.put(str[i], (char) ('a' + i));
        }

        // letter의 모스부호는 공백으로 나누어져 있습니다.
        String[] words = letter.split(" ");
        for (String word : words) {
            answer += toEnglish.get(word);
        }

        return answer;
    }
}
