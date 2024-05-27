package ColumbusStudy.week9_다익스트라;

import java.io.*;
import java.util.*;

public class Question1 {
    // https://www.acmicpc.net/problem/1753

    static ArrayList<ArrayList<Edge>> grape;
    static int V, E;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점 - 간선
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        // 초기화
        // grape = new ArrayList<ArrayList<Edge>>();
        grape = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            grape.add(new ArrayList<Edge>());
        }
        dis = new int[V + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()); // u -> v 가중치 w
            int v = Integer.parseInt(st.nextToken()); // 간선
            int w = Integer.parseInt(st.nextToken()); // 가중치

            grape.get(u).add(new Edge(v, w));
        }
        solution(K);

        for(int i = 1 ; i <= V ; i++){
            if(dis[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dis[i]);
        }
    }

    static void solution(int K){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));
        dis[K] = 0; // 시작점
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int now = e.vex;
            int nowCost = e.cost;
            // 현재의 비용이 이전보다 크다면 스킵
            if(nowCost > dis[now]) continue;
            for(Edge ob : grape.get(now)){
                if(dis[ob.vex] > nowCost + ob.cost){
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
