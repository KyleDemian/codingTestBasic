package ColumbusStudy.week6;

import java.io.*;
import java.util.*;

public class Question12 {

    // https://www.acmicpc.net/problem/14940

    static int n, m;
    static int[][] ch, grape;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // System.out.print 출력하다가, 속도 이슈로 StringBuilder 로 변경
        // IO가 엄청나게 메모리를 먹음
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ch = new int[n][m];
        grape = new int[n][m];

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                grape[i][j] = Integer.parseInt(line[j]);
                if(grape[i][j] == 2){
                    x = i;
                    y = j;
                } else if(grape[i][j] == 1){
                    ch[i][j] = -1;
                }
            }
        }

        BFS(x, y);

        // 단순 출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(ch[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    
    static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        ch[x][y] = 0;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx <n && ny >=0 && ny < m && ch[nx][ny] == -1 &&  grape[nx][ny] != 0){
                    ch[nx][ny] = ch[x][y] +1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
