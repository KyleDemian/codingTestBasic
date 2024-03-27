package day11;

import java.io.IOException;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) throws IOException {
        Question2 q = new Question2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        int n = kb.nextInt();
        int m = kb.nextInt();
        System.out.println(q.solution(str, n, m));
    }

    public String solution(String my_string, int num1, int num2) {
        String answer = "";

        char[] chars = my_string.toCharArray();
        char temp = chars[num1];
        chars[num1] = chars[num2];
        chars[num2] = temp;

        answer = new String(chars);
        return answer;

    }
}
