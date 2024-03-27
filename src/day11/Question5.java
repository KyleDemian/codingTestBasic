package day11;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question5 {
    public static void main(String[] args) throws IOException {
        Question5 q = new Question5();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(q.solution(str));
    }

    public String  solution(String n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

//        for (char x : n.toCharArray()) {
//            if(sb.indexOf(String.valueOf(x)) == -1){
//                sb.append(x);
//            }
//        }

        Set<Character> set = new HashSet<>();
        for (char x : n.toCharArray()) {
            if (set.add(x)) {
                sb.append(x);
            }
        }

        answer = sb.toString();

        return answer;
    }
}
