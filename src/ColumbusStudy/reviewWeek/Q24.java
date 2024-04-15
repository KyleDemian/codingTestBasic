package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String type = st.nextToken();
                hm.put(type, hm.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int x : hm.values()) {
                // +1 을 해주는 이유는 알몸때문에
                result *= (x+1);
            }

            System.out.println(result-1);
        }
    }
}
