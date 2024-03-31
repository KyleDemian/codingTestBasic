package day12;

import java.util.stream.IntStream;

public class Question1 {

    // 특정 문자 // N 개로 나누기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120913
    // \\G: 이 스페셜 문자는 이전에 일치되었던 위치의 끝을 가리킵니다. 처음에는 문자열의 시작 부분을 가리킵니다.
    // .{n}: 이는 n개의 아무 문자나(.)를 의미합니다.
    // (?<=...): 이는 look-behind assertion입니다. 여기서는 n개의 문자 다음의 위치를 의미합니다.
    public String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length()/n + 1];
        answer = my_str.split("(?<=\\G.{" + n + "})");

        return answer;
    }
}
