package ColumbusStudy.week9_다익스트라;

import java.util.*;
import java.io.*;

public class Question2 {
    // https://www.acmicpc.net/problem/17396

    static int n, m;
    static boolean[] sight;
    static ArrayList<Edge>[] list;
    static long[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sight = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 1) sight[i] = true;
            else sight[i] = false;
        }

        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, c));
            list[e].add(new Edge(s, c));
        }
        //입력 끝

        dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        dijkstra();

        if(dist[n - 1] == Long.MAX_VALUE) System.out.println("-1");
        else System.out.println(dist[n - 1]);
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        pq.offer(new Edge(0, 0));

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int now = e.vet;
            long nowCost = e.cost;

            if(visited[now]) continue;
            visited[now] = true;

            for(int i = 0; i < list[now].size(); i++) {
                Edge next = list[now].get(i);
                if(next.vet != n - 1 && sight[next.vet]) continue;
                if(dist[next.vet] > dist[now] + next.cost) {
                    dist[next.vet] = dist[now] + next.cost;
                    pq.offer(new Edge(next.vet, dist[next.vet]));
                }
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        int vet;
        long cost;

        public Edge(int vet, long cost) {
            this.vet = vet;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge n) {
            return (int) (this.cost - n.cost);
        }
    }
}
