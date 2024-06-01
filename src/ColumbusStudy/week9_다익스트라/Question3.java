package ColumbusStudy.week9_다익스트라;

import java.io.*;
import java.util.*;

public class Question3 {

    // https://www.acmicpc.net/problem/1238 (필수)
    static int N, M, X;
    static int[] forwardTime, backwardTime;
    static ArrayList<ArrayList<Edge>> forward, backward;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());   // X 목적지 및 출발지

        forward = new ArrayList<ArrayList<Edge>>();
        backward = new ArrayList<ArrayList<Edge>>();
        forwardTime = new int[N + 1];
        backwardTime = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            forward.add(new ArrayList<Edge>());
            backward.add(new ArrayList<Edge>());
        }
        Arrays.fill(forwardTime, Integer.MAX_VALUE);
        Arrays.fill(backwardTime, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            forward.get(start).add(new Edge(end, time));
            backward.get(end).add(new Edge(start, time));
        }

        solution(forward, forwardTime, X);
        solution(backward, backwardTime, X);

        int max = -1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, forwardTime[i] + backwardTime[i]);
        }
        System.out.println(max);

    }

    static void solution(ArrayList<ArrayList<Edge>> grape, int[] time, int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        time[start] = 0; // 자신의 위치는 최소값인 0으로
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int now = e.vet;
            int nowTime = e.time;
            for (Edge ob : grape.get(now)) {
                if(time[ob.vet] > nowTime + ob.time){
                    time[ob.vet] = nowTime + ob.time;
                    pq.offer(new Edge(ob.vet, time[ob.vet]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vet, time;

        public Edge(int vet, int time) {
            this.vet = vet;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {  // 오른차순
            return this.time - o.time;
        }
    }
}
