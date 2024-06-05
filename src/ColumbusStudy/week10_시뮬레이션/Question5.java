package ColumbusStudy.week10_시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question5 {
    // https://www.acmicpc.net/problem/21610

    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    static int N, M;
    static int[][] map;
    static boolean[][] cloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        cloud = new boolean[N+1][N+1];

        //Step 1 : 격자에 수분을 할당
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Step 2 : 초기 구름 위치 설정
        cloud[N][1] = cloud[N][2] = true;
        cloud[N-1][1] = cloud[N-1][2] = true;

        // Step 3 : 구름 이동 및 비내리기, 물 복사 버그 마법 시전
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 방향
            int s = Integer.parseInt(st.nextToken()); // 거리
            moveCloud(d, s);
            rain();
            waterCopyBugMagic();
            makeCloud();
        }

        // Step 4 : 최종 격자의 수분의 양 합산
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    // 구름 이동
    static void moveCloud(int d, int s) {
        boolean[][] tmp = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j]) {
                    int nx = (i+dx[d]*s)%N;
                    int ny = (j+dy[d]*s)%N;
                    if (nx <= 0) nx += N;
                    if (ny <= 0) ny += N;
                    tmp[nx][ny] = true;
                }
            }
        }
        cloud = tmp;
    }

    // 비내리기
    static void rain() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j]) map[i][j]++;
            }
        }
    }

    // 물 복사 버그 마법
    static void waterCopyBugMagic() {
        int[] copydx = {-1, -1, 1, 1};
        int[] copydy = {-1, 1, -1, 1};

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(cloud[i][j]) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + copydx[k];
                        int ny = j + copydy[k];

                        if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                        if(map[nx][ny]>0) cnt++;
                    }
                    map[i][j] += cnt;
                }
            }
        }
    }

    // 구름 재 생성 및 수분 감소
    static void makeCloud() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= 2 && !cloud[i][j]) {
                    cloud[i][j] = true;
                    map[i][j] -= 2;
                } else {
                    cloud[i][j] = false;
                }
            }
        }
    }
}
