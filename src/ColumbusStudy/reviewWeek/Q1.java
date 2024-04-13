package ColumbusStudy.reviewWeek;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        String str = kb.next();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += str.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
