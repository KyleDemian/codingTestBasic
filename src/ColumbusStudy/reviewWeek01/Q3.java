package ColumbusStudy.reviewWeek01;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine().toUpperCase();

        int[] cnt = new int[26];
        int max = 0;
        String answer = "?";

        for (char x : str.toCharArray()) {
            cnt[x - 'A']++;
            if(max < cnt[x - 'A']){
                max = cnt[x - 'A'];
                answer = String.valueOf(x);
            } else if (max == cnt[x - 'A']) {
                answer = "?";
            }
        }

        System.out.println(answer);
    }
}
