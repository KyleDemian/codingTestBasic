package day11;

import java.io.IOException;
import java.util.Scanner;

public class Question6 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/120834
    public static void main(String[] args) throws IOException {
        Question6 q = new Question6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(q.solution(n));
    }

    public String solution(int age) {
        String answer = "";
        String[] al = {"a","b","c","d","e","f","g","h","i","j"};
        String str = String.valueOf(age);
        for(char x : str.toCharArray()){
            int num = Character.getNumericValue(x);
            answer += al[num];
        }

        return answer;
    }
}
