package day12;

public class Question3 {

    // 중복된 문자 제거
    // https://school.programmers.co.kr/learn/courses/30/lessons/120888
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(char x : my_string.toCharArray()){
            if(sb.indexOf(String.valueOf(x)) == -1){
                sb.append(x);
            }
        }

        answer = sb.toString();
        return answer;
    }
}
