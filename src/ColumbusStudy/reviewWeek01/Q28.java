package ColumbusStudy.reviewWeek01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q28 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int tip = arr[i] -i;
            if (tip > 0) {
                answer += tip;
            }
        }
        System.out.println(answer);
    }
}
