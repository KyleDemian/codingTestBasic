package ColumbusStudy.week10_simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question3 {

    // https://www.acmicpc.net/problem/5212
    // 복습 완
    static String[][] grape;
    static int[][] ch;
    static int R,C;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grape = new String[R][C];
        ch = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grape[i][j] = line.charAt(j) + "";
                if ("X".equals(grape[i][j])) {
                    ch[i][j] = 1;
                    list.add(new int[]{i, j});
                }
            }
        }

        island();

        // 최소 값
        int minX = R, minY = C;
        int maxX = 0, maxY = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(ch[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);

                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                if(ch[i][j] == 1) {
                    sb.append("X");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void island() {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int cnt = 0;

            // 현재 육지 기준 3면 이상인 섬을 확인
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >=0 && nx < R && ny >= 0 && ny < C){
                    if(".".equals(grape[nx][ny])) cnt++;
                } else {
                    // 범위를 넘어서는 곳은 전부 바다라는것 확인 해야만 함 << 이거때문에 틀림.
                    cnt++;
                }
            }

            //해당 섬이 3면 이상이 바다라면 섬을 바다로 변경
            if (cnt >= 3) {
                ch[x][y] = 0;
            }
        }
    }
}
