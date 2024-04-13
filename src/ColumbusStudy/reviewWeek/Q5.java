package ColumbusStudy.reviewWeek;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Q5 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        StringBuilder sb = new StringBuilder();

        // Error 케이스를 확실하게 알아야지만 풀 수 있음.
        if(str == null || str.isEmpty() ||
                str.startsWith("_") || str.endsWith("_") ||
                str.contains("__") ||
                Pattern.compile("[A-Z]").matcher(str.substring(0, 1)).find() ||
                (Pattern.compile("[A-Z]").matcher(str).find() && str.contains("_"))
        ) {
            sb.append("Error!");
        } else {
            if (str.contains("_")) {
                String[] arr = str.split("_");
                for (int i = 0; i < arr.length; i++) {
                    if(i != 0) sb.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1).toLowerCase());
                    else sb.append(arr[i].toLowerCase());
                }
            } else if (stringContain(str)) {
                for (char x : str.toCharArray()) {
                    if (Character.isUpperCase(x)) {
                        sb.append("_").append(Character.toLowerCase(x));
                    } else sb.append(x);
                }
            } else sb.append(str);
        }
        System.out.println(sb.toString());
    }

    static boolean stringContain(String str) {
        for (char x : str.toCharArray()) {
            if (Character.isUpperCase(x)) {
                return true;
            }
        }
        return false;
    }
}
