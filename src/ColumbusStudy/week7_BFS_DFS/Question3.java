package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Question3 {

    // https://www.acmicpc.net/problem/5547
    // https://cm-me0410.tistory.com/entry/%EB%B0%B1%EC%A4%80%EC%9E%90%EB%B0%945547%EC%9D%BC%EB%A3%A8%EB%AF%B8%EB%84%A4%EC%9D%B4%EC%85%98%EC%9C%A1%EA%B0%81%ED%96%89%EB%A0%ACBFS

    static int moveOdd[][]  = { {0, -1}, { -1,  0}, {0, 1}, {1, 1}, {1,  0}, {-1, 1}};//홀수 행
    static int moveEven[][] = { {0, -1}, { -1, -1}, {0, 1}, {1, 0}, {1, -1}, {-1, 0}};//짝수 행
    static int map[][];
    static int isInjac[][];
    static boolean visit[][];
    static int w, h;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //열(w), 행(h)
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map     = new int[h+2][w+2];
        isInjac = new int[h+2][w+2];
        visit   = new boolean[h+2][w+2];

        for(int i=1; i<=h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    visit[i][j] = true;
                }
            }
        }

        bfs(0,0);

        int ans = 0;
        for(int i=0; i<isInjac.length; i++) {
            for(int j=0; j<isInjac[i].length; j++) {
                if(isInjac[i][j] == 0) continue;
                ans += isInjac[i][j];
            }
        }

        System.out.println(ans);

        /*
         * for(int a[] : isInjac) { for(int aa : a) { System.out.print(aa + " "); }
         * System.out.println(); }
         */
    }

    private static void bfs(int x, int y) {
        // TODO Auto-generated method stub
        Queue<hex> q = new LinkedList<hex>();
        q.add(new hex(x, y));
        visit[x][y] = true;

        while(!q.isEmpty()) {
            hex now = q.poll();
            int nextX = 0;
            int nextY = 0;

            for(int i=0; i<6; i++) {
                if(now.x % 2 == 0) {//현재위치의 y가 짝수라면
                    nextX = now.x + moveEven[i][0];
                    nextY = now.y + moveEven[i][1];
                }else {//현재 위치의 y가 홀수라면
                    nextX = now.x + moveOdd[i][0];
                    nextY = now.y + moveOdd[i][1];
                }

                //조건 설정하기
                if(nextX <0 || nextY < 0 || nextX >= h+2 || nextY >= w+2) continue;

                if(map[nextX][nextY] == 1) {
                    isInjac[now.x][now.y]++;
                    continue;
                }

                if(visit[nextX][nextY] || isInjac[nextX][nextY] != 0) continue;


                visit[nextX][nextY] = true;
                q.add(new hex(nextX, nextY));

            }
        }
    }

    static class hex{
        int x, y;
        public hex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


