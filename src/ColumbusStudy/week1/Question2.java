package ColumbusStudy.week1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Question2 {

    // https://www.acmicpc.net/problem/9046
    // 이미 암호화된 텍스트를 입력을 받고,
    // 입력받은 텍스트중에서 가장 출력이 빈번하게 출력되는 텍스트를 찾아서 해당 텍스트를 뿌려주는것
    // 그리고 그 카운트가 2건 이상이라면 ? 를 출력하는것이다.
    // 문제의 평문// 암호화문 그걸 신경쓰지 말것.. ㅠㅠㅠ
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
            int maxCount = 0;

            // 최대 빈도수 및 해당 문자의 인덱스 찾기 // 총 26번 돌아감
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
