package ColumbusStudy.week7;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question4 {

    // https://www.acmicpc.net/problem/7569

    static int M, N, H;
    static int[][][] arr;
    static Queue<Tomato> q;

    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());

                    if (arr[h][n][m] == 1) {
                        q.offer(new Tomato(h, n, m, 0));
                    }
                }
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        int day = 0;

        while(!q.isEmpty()) {
            Tomato t = q.poll();
            day = t.day;

            for (int i = 0; i < 6; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nz = t.z + dz[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if(arr[nz][nx][ny] == 0) {
                        arr[nz][nx][ny] = 1;
                        q.offer(new Tomato(nz, nx, ny, day + 1));
                    }
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) return -1;
                }
            }
        }

        return day;
    }
}

class Tomato {
    int x, y, z, day;

    Tomato(int z, int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}
