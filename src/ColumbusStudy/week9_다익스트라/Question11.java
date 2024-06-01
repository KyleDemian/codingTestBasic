package ColumbusStudy.week9_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question11 {

    // https://www.acmicpc.net/problem/16987 (필수)
    static int N;
    static int result = 0;
    static ArrayList<Egg> eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 계란1 무게 5, 내구도 7
        // 계란2 무게 4, 내구도 3
        // 두개 부딪히면 -> 계란 1 무게5, 내구도3 // 계란2 무게4, 내구도 -2 -> 내구도 -> 무게// 무게 -> 내구도

        eggs = new ArrayList<Egg>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(a, b));
        }

        DFS(0);

        System.out.println(result);
    }

    static void DFS(int L){
        if(L == N){
            int tmp = 0;
            for(Egg ob : eggs){
                if(ob.s <= 0) tmp++;
            }
            result = Math.max(result, tmp);
            return;
        } else {
            if (eggs.get(L).s <= 0) {
                DFS(L + 1);
            } else {
                boolean isBroken = false;

                for (int i = 0; i < N; i++) {
                    // 같은 및 이미 깨진 것
                    if(L == i || eggs.get(i).s <= 0) continue;

                    isBroken = true;
                    // 서로 부딪힘
                    eggs.get(L).s -= eggs.get(i).w;
                    eggs.get(i).s -= eggs.get(L).w;

                    DFS(L + 1);

                    eggs.get(L).s += eggs.get(i).w;
                    eggs.get(i).s += eggs.get(L).w;
                }

                if(!isBroken) DFS(L + 1);
            }
        }
    }

    static class Egg implements Comparable<Egg>{
        int s, w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        @Override
        public int compareTo(Egg o) {
            if(o.s == this.s) return this.w - o.w;
            else return this.s - o.s;
        }
    }
}
