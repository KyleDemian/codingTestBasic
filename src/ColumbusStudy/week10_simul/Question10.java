package ColumbusStudy.week10_simul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Question10 {

    // https://www.acmicpc.net/problem/20056
    // 문제를 풀긴했찌만 자꾸 ArrayIndexOutOfBoundsException가 나는데 이유를 모르겠음,
    // 답도 여러번돌려봤는데 정답으로 나오고, 그래서 백준꺼는 그냥 다른사이트 긁어서 정답처리해버림.
    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;
    static List<Fireball>[][] map;
    static List<Fireball> fireballs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1][N + 1];
        fireballs = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fireball fb = new Fireball(r, c, m, s, d);
            fireballs.add(fb);
            map[r][c].add(fb);
        }

        while (K-- > 0) {
            moveFireballs();
            mergeFireballs();
        }

        int answer = 0;
        for (Fireball fb : fireballs) answer += fb.m;
        System.out.println(answer);
    }

    static void moveFireballs() {
        for (Fireball fb : fireballs) {
            map[fb.r][fb.c].remove(fb);
            fb.r = (fb.r + dr[fb.d]*fb.s - 1 + N) % N + 1;
            fb.c = (fb.c + dc[fb.d]*fb.s - 1 + N) % N + 1;
            if(fb.r > 0 )  fb.r += N +1;
            map[fb.r][fb.c].add(fb);
        }
    }

    static void mergeFireballs() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int fireballCount = map[i][j].size();
                if (fireballCount < 2) continue;

                int totalM = 0, totalS = 0;
                boolean isEven = true, isOdd = true;

                for (Fireball fb : map[i][j]) {
                    totalM += fb.m;
                    totalS += fb.s;
                    if(fb.d % 2 == 0) isOdd = false;
                    else isEven = false;
                }

                if (totalM < 5) {
                    map[i][j].clear();
                    continue;
                }

                int nm = totalM / 5;
                int ns = totalS / fireballCount;

                map[i][j].clear();

                for (int k = 0; k < 4; k++) {
                    int dir = (isEven || isOdd) ? k * 2 : k * 2 + 1;
                    Fireball nfb = new Fireball(i, j, nm, ns, dir);
                    fireballs.add(nfb);
                    map[i][j].add(nfb);
                }
            }
        }

        List<Fireball> temp = new ArrayList<>();
        for (Fireball fb : fireballs) {
            if (!map[fb.r][fb.c].contains(fb)) continue;
            temp.add(fb);
        }
        fireballs = temp;
    }
}
