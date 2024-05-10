package ColumbusStudy.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question10 {

    // https://www.acmicpc.net/problem/16954

    static int n = 8, result = 0;
    static String[][] grape;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grape = new String[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grape[i][j] = line.substring(j, j + 1);
            }
        }

        BFS(grape);

        System.out.println(result);
    }

    static void BFS(String[][] grape) {
        boolean[][][] visited = new boolean[n][n][n*n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{7, 0, 0}); // 처음 위치 설정
        visited[7][0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];

            if(x == 0 && y == 7){
                result = 1;
                return;
            }

            for(int i=0; i<9; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(nx-t >= 0 && "#".equals(grape[nx-t][ny])) continue; // 이동하려는 칸에 벽이 내려와 있는지 체크

                    //벽이 내려와 있는지 체크
                    if(nx-t-1 >= 0 && "#".equals(grape[nx-t-1][ny])) continue;

                    //벽에 안전한지 체크
                    if(!visited[nx][ny][t+1]){
                        visited[nx][ny][t+1] = true;
                        q.offer(new int[]{nx, ny, t+1});
                    }
                }
            }
        }
    }
}
