package ColumbusStudy.reviewWeek01;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();

        String answer = "?";

        while (n-- > 0) {
            String str = kb.nextLine().replace(" ", "");

            int[] cnt = new int[26];

            for (char x : str.toCharArray()) {
                cnt[x - 'a']++;
            }

            int maxIdx = 0; // 가장 높은 수
            int maxCnt = 0; // 동일한 최대 빈도
            for (int i=0 ; i < cnt.length; i++) {
                if (cnt[i] > cnt[maxIdx]) {
                    maxIdx = i;
                    maxCnt = 0;
                }else if (cnt[i] == cnt[maxIdx]) {
                    maxCnt++;
                }

                if (maxCnt > 1) { // 동일한 빈도수를 가진 다른 문자가 있으면
                    System.out.println("?");
                } else {
                    System.out.println((char) ('a' + maxIdx));
                }
            }
        }
    }
}
