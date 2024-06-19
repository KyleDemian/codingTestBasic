package ColumbusStudy.week12_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question5 {

    // https://www.acmicpc.net/problem/2146
    // 틀렸던 이유는 edgeQueue 에는 가장자리의 값, -> 다음값이 아님!
    static int N;
    static int[][] ch, grape;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static Queue<int[]> edgeQueue = new LinkedList<>();

    // 데이터 입력 발생
    public static void main(String[] args) throws IOException {
        Question5 q = new Question5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grape = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(q.solution());
    }

    // 프로그래머스 입력 방법으로 등록
    static int solution() {
        ch = new int[N][N];
        visited = new boolean[N][N];

        int cnt = 1;
        // 섬에 번호를 붙이기 및 가장자리 확인하는 부분
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grape[i][j] == 1 && !visited[i][j]) {
                    bfsIsland(i, j, cnt);
                    cnt++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        while (!edgeQueue.isEmpty()) {
            int[] edge = edgeQueue.poll();
            int x = edge[0];
            int y = edge[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (grape[nx][ny] == 0) {
                        grape[nx][ny] = grape[x][y];
                        ch[nx][ny] = ch[x][y] + 1;
                        edgeQueue.offer(new int[]{nx, ny});
                    }

                    if (grape[x][y] != grape[nx][ny]) {
                        answer = Math.min(answer, ch[nx][ny] + ch[x][y]);
                    }
                }
            }
        }

        return answer;
    }

    // 섬 찾기 로직
    static void bfsIsland(int i, int j, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grape[i][j] = cnt;
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] nowQ = q.poll();
            int x = nowQ[0];
            int y = nowQ[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    // 범위 안에 있는 부분 체크
                    if (grape[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        grape[nx][ny] = cnt;
                        visited[nx][ny] = true;
                    }

                    // 물과 맡닿아 있는 큐에 삽입
                    if (!visited[nx][ny] && grape[nx][ny] == 0) {
                        edgeQueue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}