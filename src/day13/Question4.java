package day13;

import java.util.HashMap;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(kb.next(), 0);
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            String str = kb.next();
            if (hm.containsKey(str)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
