package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q35 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.toLowerCase();
        str = str.replaceAll("[^a-z0-9-_.]", "");
        str = str.replaceAll("\\.{2,}", ".");
        str = str.replaceAll("^[.]|[.]&", "");
        if (str.equals("") || str == null || str.isEmpty()) {
            str = "a";
        }
        if (str.length() > 15) {
            str = str.substring(0, 15);
            str = str.replaceAll("^[.]|[.]&", "");
        }

        if (str.length() < 3) {
            for (int i = 0; i < 3; i++) {
                str += str.charAt(str.length()-1);
            }
        }

        System.out.println(str);
    }
}
