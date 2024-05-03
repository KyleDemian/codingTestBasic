package ColumbusStudy.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question13 {
    // https://www.acmicpc.net/problem/12851
    // 1697번. 숨바꼭질
    // 13549번. 숨바꼭질 3
    // 13913번. 숨바꼭질 4
    // 출력이 이해가 안되네..?
    // 첫째 줄에 n이가 k를 찾는 가장 빠른 시간을 출력한다.
    // 둘째 줄에는 가장 빠른 시간으로 n이 k을 찾는 방법의 수를 출력한다.

    static int n, k;
    static int[] dx = {-1, 1, 2}, ch, ways;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ch = new int[100001];
        ways = new int[100001];

        ways[n] = 1;
        ch[n] = 1;

        int time = BFS(n, k);

        System.out.println(time);
        System.out.println(ways[k]);
    }

    static int BFS(int start, int end) {
        q.offer(start);
        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();

                if (tmp == end) // ways[k]가 처음으로 0이 아닌 값을 가질 때의 answer
                    return ch[end] - 1;

                for(int j = 0; j < dx.length; j++) {
                    int nx = dx[j] == 2 ? tmp * 2 : tmp + dx[j];
                    if(nx >= 0 && nx <= 100000) {
                        if(ch[nx] == 0) {
                            ch[nx] = ch[tmp] + 1;
                            ways[nx] = ways[tmp];
                            q.offer(nx);
                        }
                        else if (ch[tmp] + 1 == ch[nx]) {
                            ways[nx] += ways[tmp];
                        }
                    }
                }
            }
        }
        return answer;
    }
}


/* 최단경로
    static void BFS(int start, int end) {
        ch[start] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int tmp = q.poll();
                for(int j = 0; j < dx.length; j++) {
                    int nx = dx[j] == 2 ? tmp * 2 : tmp + dx[j];
                    if(nx == end){ answer++; return;}
                    if (nx >= 0 && nx <= 100000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            answer++;
        }
    }
*/
