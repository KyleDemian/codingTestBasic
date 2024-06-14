package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question2 {

    // https://www.acmicpc.net/problem/4779
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null && !input.equals("")) {
            int n = Integer.parseInt(input);
            // Math.pow 거듭제곱
            char[] text = new char[(int) Math.pow(3, n)];
            Arrays.fill(text, '-');

            // n 차 만큼의 횟수
            for(int i = 0; i < n; i++) {
                // 1차 가운데 공백 횟수 만큼 공백 만듬 i+1
                for(int j = 0; j < text.length; j += (int) Math.pow(3, i+1)) {
                    // 그 공백의 시작과, 끝만큼 공백으로 변경
                    int start = j + (int) Math.pow(3, i);
                    int end = start + (int) Math.pow(3, i);
                    Arrays.fill(text, start, end, ' ');
                }
            }

            System.out.println(text);
        }
    }
}
