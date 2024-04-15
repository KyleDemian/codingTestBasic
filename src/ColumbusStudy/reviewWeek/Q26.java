package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Q26 {

    static int getTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] time = br.readLine().split(" ");
        int s = getTime(time[0]);
        int e = getTime(time[1]);
        int r = getTime(time[2]);

        String input;
        int result = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> in = new HashSet<>();
        HashSet<String> out = new HashSet<>();
        while ((input = br.readLine()) != null && !input.equals("")) {
            StringTokenizer st = new StringTokenizer(input, " ");
            int chatTime = getTime(st.nextToken());
            String user = st.nextToken();

            if (0 <= chatTime && chatTime <= s && !in.contains(user)) {
                in.add(user);
                hm.put(user, hm.getOrDefault(user, 0) + 1);
            }

            if (e <= chatTime && chatTime <= r && !out.contains(user) && in.contains(user)) {
                out.add(user);
                hm.put(user, hm.getOrDefault(user, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}
