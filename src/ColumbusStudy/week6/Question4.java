package ColumbusStudy.week6;

import java.io.*;
import java.util.*;

public class Question4 {
    // https://www.acmicpc.net/problem/1012
    // 확실히 어제 들었던 강의덕인디 이해가 쉬웠다.

    static int t, m, n, k, answer;
    static int[][] grape;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        // t 만큼 반복
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 행
            m = Integer.parseInt(st.nextToken());   // 열
            k = Integer.parseInt(st.nextToken());   // 배추의 위치

            grape = new int[n][m];
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                grape[a][b] = 1;
            }

            answer = 0;

            for(int x = 0; x < n; x++) {
                for(int y = 0; y < m; y++) {
                    if(grape[x][y] == 1) {
                        d(x, y);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

    }

    static void d(int x, int y){
        grape[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x+ dx[i];
            int ny = y+ dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && grape[nx][ny] == 1){
                d(nx, ny);
            }
        }
    }
}
