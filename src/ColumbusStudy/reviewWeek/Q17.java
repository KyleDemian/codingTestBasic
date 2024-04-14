package ColumbusStudy.reviewWeek;

import java.util.Scanner;

public class Q17 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        boolean[] checked = new boolean[n + 1];
        int k = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (!checked[j]) {
                    checked[j] = true;
                    k++;
                    if (k == m) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}
