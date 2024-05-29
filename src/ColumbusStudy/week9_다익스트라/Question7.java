package ColumbusStudy.week9_다익스트라;

import java.io.*;
import java.util.*;

public class Question7 {

    // https://www.acmicpc.net/problem/2075
    static int N;
    static int[][] grape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        N = Integer.parseInt(br.readLine());
        grape = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
                pq.add(grape[i][j]);
            }
        }

        // 프로그래머스에서는 그 표 자체가 들어오기때문에 그걸로 확인하는게 맞는듯..?
//        for (int i = 0; i < N; i++) {
//            for(int j = 0; j < N; j++) {
//                pq.offer(grape[i][j]);
//            }
//        }

        for(int i = 0; i < N -1 ; i++) pq.remove();
        System.out.println(pq.poll());
    }

    // 프로그래머스라면 이렇게.
    static int solution(int[][] grape, int N) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                pq.offer(grape[i][j]);
            }
        }

        for(int i = 0; i < N -1 ; i++) pq.remove();
        answer = pq.poll();
        return answer;
    }
}
