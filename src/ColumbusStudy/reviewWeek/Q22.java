package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Double> hm = new HashMap<>();
        double total = 0.0;

        // 해당 부분, 인풋이 없거나, 공백일경우 끝날 수 있도록, 해당 방식처럼
        // 외워둘것!!
        String input;
        while ((input = br.readLine()) != null && !input.equals("")) {
            total++;
            hm.put(input, hm.getOrDefault(input, 0.0) + 1.0);
        }

        Map<String, Double> sort = new TreeMap<>(hm);
        for (Map.Entry<String, Double> entry : sort.entrySet()) {
            String key = entry.getKey();
            Double val = entry.getValue();
            double percent = (val / total) * 100;

            sb.append(key).append(" ").append(String.format("%.4f", percent)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
