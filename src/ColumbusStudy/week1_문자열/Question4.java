package ColumbusStudy.week1_문자열;

import java.util.*;
import java.util.regex.Pattern;

public class Question4 {

    // https://www.acmicpc.net/problem/9996
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        String pa = kb.next().replace("*", ".*");
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.next();
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(Pattern.matches( pa, arr[i] )){
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
