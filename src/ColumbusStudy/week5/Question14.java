package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question14 {
    // https://www.acmicpc.net/problem/2961
    // 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.

    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static ArrayList<Flavor> list = new ArrayList<>();
    static class Flavor{
        public int s, b;

        public Flavor(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.add(new Flavor(s, b));
        }
        checked(0,1, 0);
        System.out.println(min);
    }

    public static void checked(int idx, int sTime, int bTime) {
        if (idx == n) {
            if(sTime == 1 && bTime == 0) return;
            min = Math.min(min, Math.abs(sTime - bTime));
            return;
        }
        // 선택시
        checked(idx+1, sTime*list.get(idx).s, bTime+list.get(idx).b);
        // 선택 안할시
        checked(idx+1, sTime, bTime);
    }
}
