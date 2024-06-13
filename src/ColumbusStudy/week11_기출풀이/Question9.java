package ColumbusStudy.week11_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Question9 {

    // https://www.acmicpc.net/problem/2812
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String target = br.readLine();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char c = target.charAt(i);
            while (K > 0 && !dq.isEmpty() && dq.peekLast() < c) {
                dq.removeLast();
                K--;
            }
            dq.offerLast(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.removeFirst());
        }

        System.out.println(sb.toString());
    }
}
