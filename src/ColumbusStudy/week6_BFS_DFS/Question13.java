package ColumbusStudy.week6_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question13 {
    // https://www.acmicpc.net/problem/12851
    // 복습 완
    // 1697번. 숨바꼭질
    // 13549번. 숨바꼭질 3
    // 13913번. 숨바꼭질 4

    static int N, M;
    static int[] ch, ways, dy = {-1, 1, 2};
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ways = new int[100001];
        ch = new int[100001];

        // 현위치 시작 위치
        ch[N] = 1;
        ways[N] = 1;

        // 가장 빠른 시간 출력
        System.out.println(BFS(N, M));
        System.out.println(ways[M]);
    }

    static int BFS(int start, int end) {
        q.offer(start);
        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int location = q.poll();

                // 시작값이 1이기때문에 -1을 해주어야 함
                if (location == end) return ch[end] - 1;

                for (int k = 0; k < 3; k++) {
                    int ny = (dy[k] == 2) ? location * 2 : location + dy[k];
                    if (ny >= 0 && ny <= 100000) {
                        // 해당 위치에 첫방문, 시작이 5 였으면 4, 6 , 10
                        if (ch[ny] == 0) {
                            ch[ny] = ch[location] + 1;
                            ways[ny] = ways[location];
                            q.offer(ny);
                        } else if (ch[location] + 1 == ch[ny]) {
                            ways[ny] += ways[location];
                        }
                    }
                }
            }
        }

        return answer;
    }
}