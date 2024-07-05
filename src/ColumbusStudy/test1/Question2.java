package ColumbusStudy.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2 {

    // https://www.acmicpc.net/problem/16472
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int cnt = 0, answer = 0;

        int[] count = new int[26];

        for(int start = 0, end = 0; end < str.length(); end++) {
            // 최초에 문자가 1개씩 상승
            if(count[str.charAt(end) - 'a']++ == 0) cnt++;

            // cnt가 n 보다 크면다면 줄어들때까지 start 위치를 이동
            while( n < cnt && start < end){
                if(--count[str.charAt(start++) - 'a'] == 0) cnt--;
            }

            answer = Math.max(answer, end - start + 1);
        }

        System.out.println(answer);
    }
}
