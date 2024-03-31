package day12;

public class Question2 {

    // 팩토리얼 근접값 구하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120848
    public int solution(int n) {
        int answer = 0;
        long a = 1;
        int i=1;
        while ( a <= n){
            i++;
            a *= i;
        }

        answer = i -1;

        return answer;
    }
}
