package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        HashMap<String, Integer> a = new HashMap<>();
        HashMap<Integer, String> b = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            a.put(name, i);
            b.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (str.matches("\\d+")) { // 숫자인 경우
                String result = b.get(Integer.parseInt(str));
                if(result != null){
                    sb.append(result).append("\n");
                }
            } else { // 문자인 경우
                Integer result = a.get(str);
                if(result != null){
                    sb.append(result).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
