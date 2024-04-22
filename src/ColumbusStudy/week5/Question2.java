package ColumbusStudy.week5;

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

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < text.length; j += (int) Math.pow(3, i+1)) {
                    int start = j + (int) Math.pow(3, i);
                    int end = start + (int) Math.pow(3, i);
                    Arrays.fill(text, start, end, ' ');
                }
            }

            System.out.println(text);
        }
    }
}


/*
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
            while ((input = br.readLine()) != null && !input.equals("")) {
                int n = Integer.parseInt(input);
                StringBuilder sb = new StringBuilder("-".repeat((int) Math.pow(3, n)));

                // 각 단계에 대해
                for(int step = 0; step < n; step++) {
                    StringBuilder sbNew = new StringBuilder();
                    int sizeOfSection = (int) Math.pow(3, step+1);
                    int sections = (int) Math.pow(3, n - (step + 1));
                    for(int i = 0; i < sections; i++) {
                        sbNew.append(sb.substring(i*sizeOfSection, i*sizeOfSection+sizeOfSection/3))
                             .append(" ".repeat(sizeOfSection/3))
                             .append(sb.substring(i*sizeOfSection+2*sizeOfSection/3, (i+1)*sizeOfSection));
                    }
                    sb = sbNew;
                }
                System.out.println(sb.toString());
            }
    }
*/
