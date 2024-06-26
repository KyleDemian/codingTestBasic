package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Question5 {

    // https://www.acmicpc.net/problem/1600
    // 복습 완료
    static int K;
    static int W, H;
    static int[][] arr;
    static int[][][] chk;
    static int[] dx = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0 ~ 30 까지의 자연수
        K = Integer.parseInt(br.readLine());

        StringTokenizer st =new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        chk = new int[H][W][K+1];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs(){
        chk[0][0][0] = 1;
        q.add(new Node(0, 0, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int k = node.k;

            if(x == H - 1 && y == W - 1){
                System.out.println(chk[x][y][k]-1);
                return;
            }

            for(int i=0; i<12; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<H && ny<W && arr[nx][ny]==0){
                    if(i<4 && chk[nx][ny][node.k]==0){
                        q.add(new Node(nx, ny, k));
                        chk[nx][ny][k] = chk[x][y][k] + 1;
                    }
                    else if(i>=4 && k < K && chk[nx][ny][k+1]==0){
                        q.add(new Node(nx, ny, k+1));
                        chk[nx][ny][k+1] = chk[x][y][k] + 1;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Node{
        int x;
        int y;
        int k;
        public Node(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}
