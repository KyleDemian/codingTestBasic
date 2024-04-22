package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q29 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replace("XXXX", "AAAA").replace("XX", "BB");

        if (str.contains("X")) System.out.println("-1");
        else System.out.println(str);
    }
}
