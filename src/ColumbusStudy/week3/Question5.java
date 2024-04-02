package ColumbusStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question5 {

    // https://www.acmicpc.net/problem/1620

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        // 포켓몬 도감 - 이름 Key , Value 셋팅
        HashMap<String, Integer> a = new HashMap<>();
        HashMap<Integer, String> b = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String pokemon = br.readLine();
            a.put(pokemon, i + 1);
            b.put(i + 1, pokemon);
        }

        // 찾아야할 것들
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
