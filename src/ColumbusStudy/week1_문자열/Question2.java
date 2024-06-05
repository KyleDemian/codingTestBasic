package ColumbusStudy.week1_문자열;

import java.util.Scanner;

public class Question2 {

    // https://www.acmicpc.net/problem/9046
    // 복습 완 ( 2024 06 04 )

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int T = kb.nextInt(); // 테스트 케이스 수
        kb.nextLine(); // 남은 줄바꿈 소비

        while (T-- > 0) {
            String str = kb.nextLine().replace(" ", ""); // 공백 무시

            int[] counts = new int[26]; // 각 문자의 빈도수 카운터

            // 소문자 counts 방을 만듦 ( 숫자로 들어감 )
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }

            // 오버플로우 - Integer char short  최대로 표현 할 수 잇는 범위 4byte 32 bit 1 첫 1 비트는 부호를 나타내고, 나머지는 숫자.
            // Integer.가 최소로 표현할수잇는값,
            int maxIndex = 0;
            int charCount = 0;   // 동일 문자열

            // 최대 빈도수 및 해당 문자의 인덱스 찾기 // 총 26번 돌아감
            for (int i = 0; i < counts.length; i++) {
                // 문자값의 Index임.
                if (counts[i] > counts[maxIndex]) {
                    maxIndex = i;
                    charCount = 0;
                }
                if (counts[i] == counts[maxIndex]) {
                    charCount++;
                }
            }

            if (charCount > 1) { // 동일한 빈도수를 가진 다른 문자가 있으면
                System.out.println("?");
            } else {
                System.out.println((char) ('a' + maxIndex));
            }
        }
    }
}
