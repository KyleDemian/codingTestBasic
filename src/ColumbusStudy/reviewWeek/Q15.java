package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        sb.append("<");
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
