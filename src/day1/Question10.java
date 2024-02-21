package day1;

import java.util.Scanner;

public class Question10 {

    // https://cote.inflearn.com/contest/10/problem/01-10

    public int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        int p = 100;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            }else{
                p++;
                answer[i] = p;
            }
        }

        p = 100;
        for (int i=str.length()-1; i >=0 ; i--){
            if (str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question10 T = new Question10();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        // > 왼쪽 비교, 오른쪽 비교 - 최소값을 다시 배열에 담음.
        // ex : teachermode e // -> <- 2번 진행
        for (int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}
