package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Question9 {

    // https://www.acmicpc.net/problem/18511
    // 다른사람 풀이보니까 다 재귀로 풀고, 속도가 엄청빠르네..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        String[] kArr = br.readLine().split(" ");

        int[] k = new int[m];
        for(int i = 0; i < k.length; i++) {
            k[i] = Integer.parseInt(kArr[i]);
        }
        Set<Integer> set = Arrays.stream(k).boxed().collect(Collectors.toSet());

        int val = Integer.MIN_VALUE;

        for (int i = n; i > 0; i--) {
            String a = String.valueOf(i);
            boolean checked = true;

            for (char x : a.toCharArray()) {
                if (!set.contains(Character.getNumericValue(x))) {
                    checked = false;
                    break;
                }
            }

            if (checked) {
                val = i;
                break;
            }
        }

        System.out.println(val);

    }
}
