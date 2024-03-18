package ColumbusStudy.week1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Question2 {

    // https://www.acmicpc.net/problem/9046
    // 암호화 복호화 문제 -- 문제가 잘 이해가 안되는데..
    // 입력 조건은
    // T개의 테스트 케이스로 구성되며, 각각의 테스트 케이스는 하나의 소문자와 공백으로 구성된 문자열
    // 문자열의 길이는 최소 1자 이상, 최대 255자 이하입니다.
    // 출력 조건은 다음과 같습니다:
    // 각 테스트 케이스별로 가장 빈번하게 등장하는 문자를 출력합니다.
    // 만약 가장 빈번하게 등장하는 문자가 둘 이상이면 '?'를 출력합니다.
    // 따라서 이 문제를 해결하기 위한 알고리즘은 문자열에서 각 알파벳의 빈도수를 계산한 뒤, 가장 빈번하게 등장하는 알파벳을 찾아 출력하는 것입니다.
    // 그리고 빈번하게 등장하는 알파벳이 둘 이상이라면 '?'를 출력하도록 구현하면 됌.
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int T = kb.nextInt(); // 테스트 케이스 수
        kb.nextLine(); // 남은 줄바꿈 소비

        while (T-- > 0) {
            String str = kb.nextLine().replace(" ", ""); // 공백 무시

            int[] counts = new int[26]; // 각 문자의 빈도수 카운터

            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }

            int maxIndex = 0;
            int maxCount = 0;

            // 최대 빈도수 및 해당 문자의 인덱스 찾기
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > counts[maxIndex]) {
                    maxIndex = i;
                    maxCount = 0;
                }
                if (counts[i] == counts[maxIndex]) {
                    maxCount++;
                }
            }

            if (maxCount > 1) { // 동일한 빈도수를 가진 다른 문자가 있으면
                System.out.println("?");
            } else {
                System.out.println((char) ('a' + maxIndex));
            }
        }
    }
}
