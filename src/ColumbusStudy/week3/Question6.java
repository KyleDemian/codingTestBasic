package ColumbusStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Question6 {
    // https://www.acmicpc.net/problem/4358

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> hm = new HashMap<>();
        double total = 0; // 총 나무 갯수 // 비율이라서 double 로 작업 float

        // 나무 셋팅 무제한 몇개인지 모르니까.
        while (true) {
            String t = br.readLine();
            if (t == null || t.equals("") || t.isEmpty()) break;
            total++;
            hm.put(t, hm.getOrDefault(t, 0.0) + 1.0);
        }

        // 키값 기준으로 정렬 HahMap 정렬을 할 수 없어서 트리맵으로 정렬
        Map<String, Double> sortedTree = new TreeMap<>(hm);
        StringBuilder sb = new StringBuilder();

        // 소수점 4번째 자리까지 구해야 함.
        for (Map.Entry<String, Double> entry : sortedTree.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            double percent = (value / total) * 100;

            // 오류 이유...
            sb.append(key).append(" ").append(String.format("%.4f", percent)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
