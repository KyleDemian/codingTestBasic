package ColumbusStudy.reviewWeek01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q18 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();

        ArrayList<Long> list = new ArrayList<>();

        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextLine();
        }

        Pattern pa = Pattern.compile("\\d+");

        for (int i = 0; i < arr.length; i++) {
            Matcher ma = pa.matcher(arr[i]);
            while (ma.find()) {
                list.add(Long.parseLong(ma.group()));
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        list.forEach(a ->System.out.println(a));
    }
}
