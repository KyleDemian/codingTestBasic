package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q25 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        int lt = 0, rt = arr.length-1;
        int result = 0;
        while(lt < rt){
            int sum = arr[lt] + arr[rt];

            if (sum == m) {
                result++;
                lt++;
                rt--;
            } else if (sum < m) {
                lt++;
            } else if (sum > m) {
                rt--;
            }
        }
        System.out.println(result);
    }
}
