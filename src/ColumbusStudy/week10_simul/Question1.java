package ColumbusStudy.week10_simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1 {

    // https://www.acmicpc.net/problem/8911
    // 복습 완
    static int T;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            int x = 0 , y = 0; // 시작 값
            int dir = 0; // 방향 상 우 하 좌 // 시작은 북쪽을 처다봄 dx[dir]
            int minX = 0, minY = 0;
            int maxX = 0, maxY = 0;

            for(char c : str.toCharArray()){
                switch(c){
                    case 'F':
                        x += dx[dir];
                        y += dy[dir];
                        break;
                    case 'B':
                        x -= dx[dir];
                        y -= dy[dir];
                        break;
                    case 'R':
                        dir = (dir + 3) % 4;
                        break;
                    case 'L':
                        dir = (dir + 1) % 4;
                        break;
                }
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}
