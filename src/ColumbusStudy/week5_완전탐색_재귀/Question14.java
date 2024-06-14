package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question14 {
    // https://www.acmicpc.net/problem/2961
    // 복습 완 ( 문제를 이해했따기보다는 그냥 있는걸 풀었음

    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static ArrayList<Flavor> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Flavor(a, b));
        }
        checked(0, 1, 0);
        System.out.println(min);
    }

    public static void checked(int idx, int sTime, int bTime) {
        if (idx == n) {
            if (sTime == 1 && bTime == 0) return;
            min = Math.min(min, Math.abs(sTime - bTime));
            return;
        }
        // 선택시
        checked(idx + 1, sTime * list.get(idx).s, bTime + list.get(idx).b);
        // 선택 안할시
        checked(idx + 1, sTime, bTime);
    }

    static class Flavor {
        public int s, b;

        public Flavor(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}
