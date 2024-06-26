package ColumbusStudy.week12_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question9 {

    // https://www.acmicpc.net/problem/12933
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();

        int[] arr = new int[6];
        int mx = 0;
        arr[0] = len;

        for(int i = 0; i < len; i++){
            int n = 0;
            if(str.charAt(i) == 'q') n = 1;
            if(str.charAt(i) == 'u') n = 2;
            if(str.charAt(i) == 'a') n = 3;
            if(str.charAt(i) == 'c') n = 4;
            if(str.charAt(i) == 'k') n = 5;

            // 0 이라면 이전 문자가 출현하지 않았음을 의미함
            if(arr[n-1] == 0){
                System.out.println(-1);
                return;
            }

            arr[n]++;
            arr[n - 1]--;
            mx = Math.max(mx, arr[1] + arr[2] + arr[3] + arr[4]);
        }

        if(arr[5] * 5 != len){
            System.out.println(-1);
            return;
        }

        System.out.println(mx);
    }
}
