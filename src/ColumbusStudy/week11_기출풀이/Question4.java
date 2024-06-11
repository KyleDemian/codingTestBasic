package ColumbusStudy.week11_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Question4 {

    // https://www.acmicpc.net/problem/11048
    // 복습 완

    // 접근이 틀렸음. PriorityQueue 의 경우 가장 우선순위를 가진 요소를 제공하지만
    // 해당 문제의 접근은 특정 위치의 가장 사탕수가 많은 사람을 구하는것
    // 그래서 해당 문제는 동적 프록래밍으로 접근 했었어야 함.
    static int N, M;
    static int[][] grape, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grape = new int[N+1][M+1];
        ch = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findCandy());
    }

    static int findCandy(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 방향이 오른쪽, 오른쪽대각선, 아래 만 갈수 있음
                ch[i][j] = Math.max(Math.max(ch[i][j - 1], ch[i - 1][j]), ch[i - 1][j - 1]) + grape[i][j];
            }
        }
        return ch[N][M];
    }


    /*
    static int N, M;
    static int[] dx = {0,1,1}, dy ={1,1,0};
    static int[][] grape, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grape = new int[N+1][M+1];
        ch = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
                ch[i][j] = Integer.MAX_VALUE;
            }
        }

        findCandy(1, 1, 0);

        System.out.println(ch[N][M]);
    }

    static void findCandy(int sX, int sY, int count) {
        PriorityQueue<Candy> pq = new PriorityQueue<>();
        pq.offer(new Candy(sX, sY, count));
        // 최초 사탕값 넣기.
        ch[sX][sY] = grape[sX][sY];

        while(!pq.isEmpty()){
            Candy cur = pq.poll();
            int x = cur.x;
            int y = cur.y;

            for (int k = 0; k < 3; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 어차피 뒤로 못돌아감
                if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                    if(ch[nx][ny] > ch[x][y] + grape[nx][ny]){
                        ch[nx][ny] = ch[x][y] + grape[nx][ny];
                        pq.offer(new Candy(nx, ny, ch[nx][ny]));
                    }
                }
            }
        }
    }




    static class Candy implements Comparable<Candy>{
        int x, y, cost;

        public Candy(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Candy ob){
            return ob.cost - this.cost;
        }
    }


    */
}
