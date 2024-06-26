package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question4 {

    // https://www.acmicpc.net/problem/7569

    static int N, M, H;
    static int[][][] grape;
    static Queue<Tomato> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0}, dy = {0, 1, 0, -1, 0 ,0} , dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken()); // 상자의 개수

        grape = new int[H][N][M];

        for(int z = 0; z < H; z++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    grape[z][i][j] = Integer.parseInt(st.nextToken());
                    if(grape[z][i][j] == 1) q.offer(new Tomato(z, i, j, 0));
                }
            }
        }

        System.out.print(BFS(0));
    }

    static int BFS(int day){
        while(!q.isEmpty()){
            Tomato t = q.poll();
            int x = t.x, y = t.y, z = t.z;
            day = t.day;

            for(int k = 0; k < 6; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = z + dz[k];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if(grape[nz][nx][ny] == 0) {
                        grape[nz][nx][ny] = 1;
                        q.offer(new Tomato(nz, nx, ny, day+1));
                    }
                }
            }
        }

        for(int z = 0; z < H; z++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(grape[z][i][j] == 0) return -1;
                }
            }
        }

        return day;
    }

    static class Tomato {
        int x, y, z, day;

        Tomato(int z, int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}


