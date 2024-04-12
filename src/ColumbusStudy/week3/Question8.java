package ColumbusStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question8 {

    // https://www.acmicpc.net/problem/9375
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n 번 진행 횟수.
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            // <의상, 타입> 의 개수
            int m = Integer.parseInt(br.readLine());
            // 같은 의상이 존재 하지 않아야함. < 타입, 숫자 >
            HashMap<String, Integer> hm = new HashMap<>();

            // 옷 상품
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                hm.put(key, hm.getOrDefault(key, 0) +1);
            }

            // 모자: 2개   ( 모자1, 모자2, 없음 )
            // 상의: 3개   ( 상의1, 상의2, 상의3 , 없음 )
            // 3 * 4 = 12 -> 알몸 -1
            int result = 1;
            for (int v : hm.values()) {
                result *= (v + 1);
            }
            sb.append(result - 1).append("\n");
        }
        System.out.print(sb.toString());
    }
}
