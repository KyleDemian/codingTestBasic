package day12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question6 {

    // 숨어있는 숫자의 덧셈
    // https://school.programmers.co.kr/learn/courses/30/lessons/120864
    public int solution(String my_string) {
        int answer = 0;

        // 숫자만 가져오는 패턴 > \\d+ -> +를 붙인 이유가 연속된 숫자들을 전체 가져옴.
        Pattern pa = Pattern.compile("\\d+");
        Matcher mat = pa.matcher(my_string);

        while (mat.find()) {
            answer += Integer.parseInt(mat.group());
        }

        // 이렇게 했을경우는 숫자 1개씩 가져옴.
//        for(char x :  my_string.toCharArray()){
//            if(Character.isDigit(x)){
//                answer += (x-48);
//            }
//        }

        return answer;
    }
}
