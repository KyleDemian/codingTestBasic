package ColumbusStudy.week4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Integer[] arr = new Integer[n];

        // 생각했던 금액
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        // 최대값을 구해야 함. 그럼 역순으로
        Arrays.sort(arr, Collections.reverseOrder());

        // 틀린 이유 -> int 형이라고 당연히 생각하고... 있었는데 long까지 올라갔어야했네.. ㅠ.,ㅠ
        long answer = 0;
        for (int i = 0; i < arr.length ; i++) {
            // 금액 = 생각한한 금액 - ( 받은 등수 - 1 ) ( (i+1) -1) -> i 값;
            int tip = arr[i] - i;
            if( tip >= 0 ) answer += tip;
        }

        System.out.println(answer);
    }
}
