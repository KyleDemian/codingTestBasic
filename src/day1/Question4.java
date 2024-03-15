package day1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {

    // https://cote.inflearn.com/contest/10/problem/01-04
    // StringBuilder 사용이유 -> String 새로운 객체를 생성 (String constant? )

    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        // 전체 Reverse
        for (String x : str) {
            answer.add(new StringBuilder(x).reverse().toString());
        }

        // 끝과 끝 Reverse // 특정문자만 바꿔야할 경우에는 1개씩 바꿔야하기에... 이런 방식도 있다고 함.
//        for (String x : str) {
//            char[] s = x.toCharArray();
//            int lt = 0, rt = x.length() -1;
//            while (lt < rt) {
//                char tmp = s[lt];
//                s[lt] = s[rt];
//                s[rt] = tmp;
//                lt++;
//                rt--;
//            }
//            String tmp = String.valueOf(s);
//            answer.add(tmp);
//        }

        return answer;
    }

    public static void main(String[] args) {
        Question4 T = new Question4();
        Scanner kb = new Scanner(System.in);
        int count = Integer.parseInt(kb.next());
//        int count = kb.next();
        String[] str = new String[count];
        for (int i = 0; i < count ; i++) {
            str[i] = kb.next();
        }

        // 3
        // good
        // Time
        // Big

        for (String x : T.solution(count, str)) {
            System.out.println(x);
        }
    }
}
