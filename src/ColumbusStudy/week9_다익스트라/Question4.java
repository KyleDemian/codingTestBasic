package ColumbusStudy.week9_다익스트라;

import java.io.*;
import java.util.*;

public class Question4 {

    // https://www.acmicpc.net/problem/1504
    // https://tussle.tistory.com/580
    static int N, M;
    static ArrayList<ArrayList<Edge>> grape;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grape = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= N; i++) {
            grape.add(new ArrayList<>());
        }

        dis = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향이긴한데.. 음..
            grape.get(a).add(new Edge(b, c));
            grape.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

//        int result1 = 0;
//        result1 = solution(1, v1);
//        result1 += solution(v1, v2);
//        result1 += solution(v2, N);
//
//        int result2 = 0;
//        result2 = solution(1, v2);
//        result2 += solution(v2, v1);
//        result2 += solution(v1, N);

        int result1 = 0;
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        result1 = solution(1, v1);
        if(dis[v1] == Integer.MAX_VALUE) result1 = Integer.MAX_VALUE;

        Arrays.fill(dis, Integer.MAX_VALUE);
        if(result1 != Integer.MAX_VALUE) {
            dis[v1] = 0;
            result1 += solution(v1, v2);
            if(dis[v2] == Integer.MAX_VALUE) result1 = Integer.MAX_VALUE;
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        if(result1 != Integer.MAX_VALUE) {
            dis[v2] = 0;
            result1 += solution(v2, N);
            if(dis[N] == Integer.MAX_VALUE) result1 = Integer.MAX_VALUE;
        }

        int result2 = 0;
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        result2 = solution(1, v2);
        if(dis[v2] == Integer.MAX_VALUE) result2 = Integer.MAX_VALUE;

        Arrays.fill(dis, Integer.MAX_VALUE);
        if(result2 != Integer.MAX_VALUE) {
            dis[v2] = 0;
            result2 += solution(v2, v1);
            if(dis[v1] == Integer.MAX_VALUE) result2 = Integer.MAX_VALUE;
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        if(result2 != Integer.MAX_VALUE) {
            dis[v1] = 0;
            result2 += solution(v1, N);
            if(dis[N] == Integer.MAX_VALUE) result2 = Integer.MAX_VALUE;
        }

        if(result1 >= Integer.MAX_VALUE && result2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    static int solution(int start, int end) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int now = e.vet;
            int nowCost = e.cost;

            for (Edge ob : grape.get(now)) {
                if (dis[ob.vet] > nowCost + ob.cost) {
                    dis[ob.vet] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vet, nowCost + ob.cost));
                }
            }
        }
        return dis[end];
    }

    static class Edge implements Comparable<Edge> {
        int vet, cost;

        public Edge(int vet, int cost) {
            this.vet = vet;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
