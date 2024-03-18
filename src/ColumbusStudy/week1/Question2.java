package ColumbusStudy.week1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Question2 {

    // https://www.acmicpc.net/problem/9046
    // 암호화 복호화 문제 -- 문제가 잘 이해가 안되는데..
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int T = kb.nextInt(); // 테스트 케이스 수
        kb.nextLine(); // 남은 줄바꿈 소비

        while (T-- > 0) {
            String str = kb.nextLine().replace(" ", ""); // 공백 무시

            int[] counts = new int[26]; // 각 문자의 빈도수 카운터

            for (char c : str.toCharArray()) {
                counts[c - 'a']++;  // 아스키코드값 숫자빼서 해당 문자의 숫자값으로 쪼갬
            }

            int max = Arrays.stream(counts).max().orElse(-1); // 최대 빈도수 찾기

            long maxCount = Arrays.stream(counts).filter(count -> count == max).count(); //최대 빈도수와 일치하는 알파벳의 수

            if (maxCount > 1) { // 동일한 빈도수를 가진 다른 문자가 있으면
                System.out.println("?");
            } else {
                int maxIndex = IntStream.range(0, counts.length).filter(i -> counts[i] == max).findFirst().orElse(-1); // 최대 빈도수의 인덱스 찾기
                System.out.println((char) ('a' + maxIndex));
            }
        }
    }
}
