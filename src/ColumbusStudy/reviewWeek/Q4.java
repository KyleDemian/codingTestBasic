package ColumbusStudy.reviewWeek;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q4 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        String pattternString = kb.nextLine().replace("*", ".*");

        for (int i = 0; i < n; i++) {
            String str = kb.nextLine();
            if (Pattern.matches(pattternString, str)) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
